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

import tk.alexander01998.galton_brett.GaltonBrett;
import tk.alexander01998.galton_brett.simulation.Entity;

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
		for(int x = 0; x < getWidth(); x += 256)
			for(int y = 0; y < getHeight(); y += 256)
				g.drawImage(TextureManager.BACKGROUND, x, y, null);
		Entity[][] grid = GaltonBrett.simulation.grid;
		for(int x = 0; x < grid.length; x++)
		{
			for(int y = 0; y < grid[x].length; y++)
			{
				Entity entity = grid[x][y];
				if(entity != null)
					entity.render(g, x, y);
			}
		}
		g.drawRect(0, 0, grid.length * 64, grid[0].length * 64);
	}
	
	public void render(float partialTicks)
	{
		this.partialTicks = partialTicks;
		repaint();
	}
}
