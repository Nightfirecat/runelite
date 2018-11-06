/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.virtuallevels;

import com.google.common.collect.ImmutableList;
import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Skill;
import net.runelite.api.WorldType;
import net.runelite.api.events.ConfigChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
	name = "Virtual Levels",
	description = "Configuration for the virtual levels plugin.",
	tags = {"skill", "total", "max", "f2p", "free"},
	enabledByDefault = false
)
public class VirtualLevelsPlugin extends Plugin
{
	private static final String TOTAL_LEVEL_TEXT_PREFIX = "Total level:<br>";

	private static final Map<WidgetInfo, SkillWidgetSwapTracker> SKILL_WIDGET_SWAP_TRACKER;

	static
	{
		SKILL_WIDGET_SWAP_TRACKER = new LinkedHashMap<>();
		SKILL_WIDGET_SWAP_TRACKER.put(WidgetInfo.SKILL_WOODCUTTING, new SkillWidgetSwapTracker(WidgetInfo.SKILL_TOTAL));
		SKILL_WIDGET_SWAP_TRACKER.put(WidgetInfo.SKILL_PRAYER, new SkillWidgetSwapTracker(WidgetInfo.SKILL_MAGIC));
		SKILL_WIDGET_SWAP_TRACKER.put(WidgetInfo.SKILL_CRAFTING, new SkillWidgetSwapTracker(WidgetInfo.SKILL_WOODCUTTING));
		SKILL_WIDGET_SWAP_TRACKER.put(WidgetInfo.SKILL_AGILITY, new SkillWidgetSwapTracker(WidgetInfo.SKILL_PRAYER));
		SKILL_WIDGET_SWAP_TRACKER.put(WidgetInfo.SKILL_HERBLORE, new SkillWidgetSwapTracker(WidgetInfo.SKILL_CRAFTING));
		SKILL_WIDGET_SWAP_TRACKER.put(WidgetInfo.SKILL_THIEVING, new SkillWidgetSwapTracker(WidgetInfo.SKILL_RUNECRAFTING));
	}

	@Inject
	private VirtualLevelsConfig config;

	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Provides
	VirtualLevelsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VirtualLevelsConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		hideMembersSkillsAndShuffle(hideMembersEnabled());
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(this::simulateSkillChange);
		hideMembersSkillsAndShuffle(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged config)
	{
		if (config.getGroup().equals("virtualLevels"))
		{
			clientThread.invoke(this::simulateSkillChange);
			hideMembersSkillsAndShuffle(hideMembersEnabled());
		}
	}

	@Subscribe
	public void onPluginChanged(PluginChanged pluginChanged)
	{
		// this is guaranteed to be called after the plugin has been registered by the eventbus. startUp is not.
		if (pluginChanged.getPlugin() != this)
		{
			return;
		}

		if (config.virtualLevelsEnabled())
		{
			clientThread.invoke(this::simulateSkillChange);
		}
		else if (config.hideMembersSkills())
		{
			hideMembersSkillsAndShuffle(hideMembersEnabled());
		}
	}

	@Subscribe
	public void onWidgetHiddenChanged(WidgetHiddenChanged event)
	{
		hideMembersSkillsAndShuffle(hideMembersEnabled());
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		final String eventName = e.getEventName();

		final int[] intStack = client.getIntStack();
		final int intStackSize = client.getIntStackSize();
		final String[] stringStack = client.getStringStack();
		final int stringStackSize = client.getStringStackSize();

		switch (eventName)
		{
			case "skillTabBaseLevel":
				final int skillId = intStack[intStackSize - 2];
				final Skill skill = Skill.values()[skillId];
				final int exp = client.getSkillExperience(skill);

				// alter the local variable containing the level to show
				intStack[intStackSize - 1] = Experience.getLevelForXp(exp);
				break;
			case "skillTabMaxLevel":
				// alter max level constant
				intStack[intStackSize - 1] = Experience.MAX_VIRT_LEVEL;
				break;
			case "skillTabTotalLevel":
				int level = 0;

				for (Skill s : Skill.values())
				{
					if (s == Skill.OVERALL)
					{
						continue;
					}
					if (hideMembersEnabled())
					{
						//only adds to level if the skill if client is in f2p world and is not a members skill
						level += s.getMembersSkill() ? 0 : Experience.getLevelForXp(client.getSkillExperience(s));
					}
					else
					{
						level += Experience.getLevelForXp(client.getSkillExperience(s));
					}
				}
				stringStack[stringStackSize - 1] = TOTAL_LEVEL_TEXT_PREFIX + level;
				break;
		}
	}

	private void simulateSkillChange()
	{
		// this fires widgets listening for all skill changes
		for (Skill skill : Skill.values())
		{
			if (skill != Skill.OVERALL)
			{
				client.queueChangedSkill(skill);
			}
		}
	}

	private ImmutableList<Widget> getMemberSkills()
	{
		return ImmutableList.of(
			client.getWidget(WidgetInfo.SKILL_AGILITY),
			client.getWidget(WidgetInfo.SKILL_CONSTRUCTION),
			client.getWidget(WidgetInfo.SKILL_FARMING),
			client.getWidget(WidgetInfo.SKILL_FLETCHING),
			client.getWidget(WidgetInfo.SKILL_HERBLORE),
			client.getWidget(WidgetInfo.SKILL_HUNTER),
			client.getWidget(WidgetInfo.SKILL_THIEVING),
			client.getWidget(WidgetInfo.SKILL_SLAYER));
	}

	private void hideMembersSkillsAndShuffle(boolean enabled)
	{
		if (client.getWidget(WidgetInfo.SKILL_TOTAL) == null)
		{
			return;
		}

		// Update widget and target original positions
		for (Map.Entry<WidgetInfo, SkillWidgetSwapTracker> entry : SKILL_WIDGET_SWAP_TRACKER.entrySet())
		{
			final Widget keyWidget = client.getWidget(entry.getKey());
			final int keyWidgetX = keyWidget.getRelativeX();
			final int keyWidgetY = keyWidget.getRelativeY();
			final SkillWidgetSwapTracker value = entry.getValue();
			final WidgetInfo valueWidgetInfo = value.getWidgetInfo();
			final int valueX = value.getX();
			final int valueY = value.getY();

			final Widget valueWidget = client.getWidget(valueWidgetInfo);
			final int newValueX = valueX > 0 ? valueX : valueWidget.getRelativeX();
			final int newValueY = valueY > 0 ? valueY : valueWidget.getRelativeY();
			if (valueX != newValueX && valueY != newValueY)
			{
				SKILL_WIDGET_SWAP_TRACKER.put(
					entry.getKey(),
					new SkillWidgetSwapTracker(
						valueWidgetInfo,
						newValueX,
						newValueY,
						keyWidgetX,
						keyWidgetY));
			}
		}

		for (Widget widget : getMemberSkills())
		{
			if (widget != null)
			{
				widget.setHidden(enabled);
			}
		}

		for (Map.Entry<WidgetInfo, SkillWidgetSwapTracker> entry : SKILL_WIDGET_SWAP_TRACKER.entrySet())
		{
			final SkillWidgetSwapTracker value = entry.getValue();
			if (enabled)
			{
				setWidgetRelativePosition(
					value.getWidgetInfo(),
					value.getTargetX(),
					value.getTargetY());
			}
			else
			{
				setWidgetRelativePosition(
					value.getWidgetInfo(),
					value.getX(),
					value.getY());
			}
		}
	}

	private boolean hideMembersEnabled()
	{
		return !client.getWorldType().contains(WorldType.MEMBERS) && config.hideMembersSkills();
	}

	private void setWidgetRelativePosition(WidgetInfo skillWidgetInfo, int x, int y)
	{
		final Widget widget = client.getWidget(skillWidgetInfo);
		if (widget == null)
		{
			return;
		}
		widget.setRelativeX(x);
		widget.setRelativeY(y);
	}
}
