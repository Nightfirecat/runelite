/*
 * Copyright (c) 2018, Seth <Sethtroll3@gmail.com>
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
package net.runelite.client.plugins.blastfurnace;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.text.NumberFormat;
import javax.inject.Inject;
import net.runelite.api.Client;
import static net.runelite.api.Varbits.BLAST_FURNACE_COFFER;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.PanelComponent;

class BlastFurnaceCofferOverlay extends Overlay
{
	private final Client client;
	private final BlastFurnacePlugin plugin;
	private final BlastFurnaceConfig config;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	BlastFurnaceCofferOverlay(Client client, BlastFurnacePlugin plugin, BlastFurnaceConfig config)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (plugin.getConveyorBelt() == null)
		{
			return null;
		}

		Widget sack = client.getWidget(WidgetInfo.BLAST_FURNACE_COFFER);

		panelComponent.getLines().clear();

		if (sack != null)
		{
			sack.setHidden(true);

			panelComponent.getLines().add(new PanelComponent.Line(
				"Coffer:",
				NumberFormat.getInstance().format(client.getSetting(BLAST_FURNACE_COFFER)) + " gp"
			));
		}
		return panelComponent.render(graphics, parent);
	}
}