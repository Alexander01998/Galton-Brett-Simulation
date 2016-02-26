/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class SimulationPanel extends JPanel
{
	private float partialTicks;
	
	/**
	 * Create the panel.
	 */
	public SimulationPanel()
	{	
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(int x = 0; x < getWidth(); x += 80)
			for(int y = 0; y < getHeight(); y += 80)
				g.drawImage(TextureManager.BACKGROUND, x, y, null);
	}
	
	public void render(float partialTicks)
	{
		this.partialTicks = partialTicks;
		repaint();
	}
}
