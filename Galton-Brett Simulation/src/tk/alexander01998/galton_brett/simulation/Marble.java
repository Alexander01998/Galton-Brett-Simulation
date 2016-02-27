/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.simulation;

import java.awt.Graphics;

import tk.alexander01998.galton_brett.GaltonBrett;
import tk.alexander01998.galton_brett.gui.TextureManager;

public class Marble
{
	private int posX;
	private int posY;
	private int oldPosX;
	private int oldPosY;
	private int timer;
	
	public Marble(int posX, int posY)
	{
		this.posX = posX;
		this.posY = posY;
		this.oldPosX = posX;
		this.oldPosY = posY;
	}
	
	public void render(Graphics g, float partialTicks)
	{
		float factor = (20F - (float)timer + partialTicks) / 20F;
		g.drawImage(TextureManager.MARBLE, (int)(posX * 64 * factor + oldPosX
			* 64 * (1 - factor)), (int)(posY * 64 * factor + oldPosY * 64
			* (1 - factor)), null);
	}
	
	public void update()
	{
		timer--;
		if(timer <= 0)
		{
			oldPosX = posX;
			oldPosY = posY;
			
			Entity[][] grid = GaltonBrett.simulation.grid;
			if(posY < grid[0].length - 1
				&& !(grid[posX][posY + 1] instanceof Wedge))
				posY++;
			timer = 20;
		}
	}
}
