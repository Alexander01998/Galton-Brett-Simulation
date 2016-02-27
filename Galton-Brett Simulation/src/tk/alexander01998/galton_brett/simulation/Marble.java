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
		g.drawImage(TextureManager.MARBLE, posX * 64, posY * 64, null);
	}
	
	public void update()
	{
		if(timer == 0)
		{
			Entity[][] grid = GaltonBrett.simulation.grid;
			if(posY < grid[0].length - 1
				&& !(grid[posX][posY + 1] instanceof Wedge))
			{
				oldPosX = posX;
				oldPosY = posY;
				posY++;
			}
			timer = 20;
		}else
			timer--;
	}
}
