/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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

package net.runelite.client.plugins.fairyring;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptEvent;
import net.runelite.api.ScriptID;
import net.runelite.api.SoundEffectID;
import net.runelite.api.SpriteID;
import net.runelite.api.Varbits;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.widgets.WidgetType;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.JavaScriptCallback;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.chatbox.ChatboxPanelManager;
import net.runelite.client.game.chatbox.ChatboxTextInput;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

@Slf4j
@PluginDescriptor(
	name = "Fairy Rings",
	description = "Show the location of the fairy ring teleport",
	tags = {"teleportation"}
)
public class FairyRingPlugin extends Plugin
{
	private static final String[] leftDial = {"A", "D", "C", "B"};
	private static final String[] middleDial = {"I", "L", "K", "J"};
	private static final String[] rightDial = {"P", "S", "R", "Q"};

	private static final String MENU_OPEN = "Open";
	private static final String MENU_CLOSE = "Close";

	@Inject
	private Client client;

	@Inject
	private FairyRingConfig config;

	@Inject
	private ChatboxPanelManager chatboxPanelManager;

	@Inject
	private ClientThread clientThread;

	private ChatboxTextInput searchInput = null;
	private Widget searchBtn;

	@Provides
	FairyRingConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FairyRingConfig.class);
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		setWidgetTextToDestination();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded)
	{
		if (widgetLoaded.getGroupId() == WidgetID.FAIRY_RING_PANEL_GROUP_ID)
		{
			setWidgetTextToDestination();

			Widget header = client.getWidget(WidgetInfo.FAIRY_RING_HEADER);
			if (header != null)
			{
				searchBtn = header.createChild(-1, WidgetType.GRAPHIC);
				searchBtn.setSpriteId(SpriteID.GE_SEARCH);
				searchBtn.setOriginalWidth(17);
				searchBtn.setOriginalHeight(17);
				searchBtn.setOriginalX(11);
				searchBtn.setOriginalY(11);
				searchBtn.setHasListener(true);
				searchBtn.setAction(1, MENU_OPEN);
				searchBtn.setOnOpListener((JavaScriptCallback) this::menuOpen);
				searchBtn.setName("Search");
				searchBtn.revalidate();

				if (config.autoOpen())
				{
					openSearch();
				}
			}
		}
	}

	private void menuOpen(ScriptEvent e)
	{
		openSearch();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void menuClose(ScriptEvent e)
	{
		chatboxPanelManager.close();
		client.playSoundEffect(SoundEffectID.UI_BOOP);
	}

	private void setWidgetTextToDestination()
	{
		Widget fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
		if (fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden())
		{
			String destination;
			try
			{
				FairyRings fairyRingDestination = getFairyRingDestination(client.getVarbitValue(Varbits.FAIRY_RING_DIAL_ADCB),
					client.getVarbitValue(Varbits.FAIRY_RIGH_DIAL_ILJK), client.getVarbitValue(Varbits.FAIRY_RING_DIAL_PSRQ));
				destination = fairyRingDestination.getDestination();
			}
			catch (IllegalArgumentException ex)
			{
				destination = "Invalid location";
			}

			fairyRingTeleportButton.setText(destination);
		}
	}

	private FairyRings getFairyRingDestination(int varbitValueDialLeft, int varbitValueDialMiddle, int varbitValueDialRight)
	{
		return FairyRings.valueOf(leftDial[varbitValueDialLeft] + middleDial[varbitValueDialMiddle] + rightDial[varbitValueDialRight]);
	}

	private void openSearch()
	{
		searchBtn.setAction(1, MENU_CLOSE);
		searchBtn.setOnOpListener((JavaScriptCallback) this::menuClose);
		searchInput = chatboxPanelManager.openTextInput("Filter fairy rings")
			.onChanged(s -> clientThread.invokeLater(this::updateFilter))
			.onDone(s -> false)
			.onClose(() ->
			{
				clientThread.invokeLater(this::updateFilter);
				searchBtn.setOnOpListener((JavaScriptCallback) this::menuOpen);
				searchBtn.setAction(1, MENU_OPEN);
			})
			.build();
		updateFilter();
	}

	@Subscribe
	public void onGameTick(GameTick t)
	{
		// This has to happen because the only widget that gets hidden is the tli one
		Widget fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON);
		boolean fairyRingWidgetOpen = fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden();
		boolean chatboxOpen = searchInput != null && chatboxPanelManager.getCurrentInput() == searchInput;

		if (!fairyRingWidgetOpen && chatboxOpen)
		{
			chatboxPanelManager.close();
		}
	}

	@Subscribe
	void onScriptCallbackEvent(ScriptCallbackEvent e)
	{
		switch (e.getEventName())
		{
			case "pinnedFairyRingBuild":
			case "fairyRingVisitedCheck":
			case "fairyTalePt2RingCheck":
			{
				final String[] stringStack = client.getStringStack();
				final int stringStackSize = client.getStringStackSize();
				final String ringCode = stringStack[stringStackSize - 1];
				final String ringDescription = stringStack[stringStackSize - 2];

				// Hide fairy ring widget if neither the code nor description match the filter term
				if (!permitCode(ringCode) && !permitDescription(ringDescription))
				{
					client.getIntStack()[client.getIntStackSize() - 1] = 0;
				}

				break;
			}
		}
	}

	/**
	 *
	 * @param ringCode
	 * @return
	 */
	private boolean permitCode(final String ringCode)
	{
		if (searchInput == null)
		{
			return true;
		}

		final String filter = searchInput.getValue().toLowerCase();

		if (filter.isEmpty())
		{
			return true;
		}

		final String code = Text.removeTags(ringCode).replaceAll(" ", "");

		if (code.isEmpty())
		{
			return false;
		}

		final String tags;

		try
		{
			FairyRings ring = FairyRings.valueOf(code);

			if (filter.equalsIgnoreCase(code))
			{
				return true;
			}

			tags = ring.getTags();
		}
		catch (IllegalArgumentException e)
		{
			log.warn("Unable to find ring with code '{}'", code, e);
			return false;
		}

		return permitDescription(tags);
	}

	/**
	 *
	 * @param ringDescription
	 * @return
	 */
	private boolean permitDescription(final String ringDescription)
	{
		if (searchInput == null)
		{
			return true;
		}

		final String filter = searchInput.getValue().toLowerCase();

		return filter.isEmpty() || Text.removeTags(ringDescription).contains(filter);
	}

	// TODO: rename this function
	private void updateFilter()
	{
		assert client.isClientThread();

		client.runScript(
			ScriptID.FAIRYRINGS_SORT_UPDATE,
			WidgetInfo.FAIRY_RING_LIST.getId(),
			WidgetInfo.FAIRY_RING_LIST_SCROLLBAR.getId(),
			1, // non-sort update
			WidgetInfo.FAIRY_RING_LIST_SEPARATOR.getId(),
			WidgetInfo.FAIRY_RING_FAVORITES.getId()
		);
	}
}
