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
	private int posX, posY;
	private int oldPosX, oldPosY;
	private int timer, timerMax;
	
	public Marble(int posX, int posY)
	{
		this.posX = posX;
		this.posY = posY;
		this.oldPosX = posX;
		this.oldPosY = posY;
	}
	
	public void render(Graphics g, float partialTicks)
	{
		boolean onWedge =
			oldPosY < GaltonBrett.simulation.grid[0].length - 1
				&& GaltonBrett.simulation.grid[oldPosX][oldPosY + 1] instanceof Wedge;
		
		float factor =
			(timerMax - timer + partialTicks) / timerMax
				* (onWedge ? 1.25F : 1F);
		float factor1 = Math.min(factor, 1);
		
		int renderX;
		if(posX == oldPosX)
			renderX = posX * 64;
		else
			renderX = (int)(posX * 64 * factor1 + oldPosX * 64 * (1 - factor1));
		
		int renderY;
		if(posY == oldPosY)
			renderY = posY * 64;
		else if(onWedge)
			renderY =
				64 * oldPosY + 32
					+ (int)(32 * -Math.sqrt(1 - Math.pow(factor * 2, 2)))
					+ (factor1 >= 0.5 ? (int)((factor1 - 0.5) * 64 * 2) : 0)
					+ (factor >= 1 ? (int)((factor - 1) * 64 * 2) : 0);
		else
			renderY = (int)(posY * 64 * factor + oldPosY * 64 * (1 - factor));
		
		g.drawImage(TextureManager.MARBLE, renderX, renderY, null);
	}
	
	public void update()
	{
		if(timer > 0)
			timer--;
		if(timer <= 0)
		{
			oldPosX = posX;
			oldPosY = posY;
			
			Entity[][] grid = GaltonBrett.simulation.grid;
			
			if(posY >= grid[0].length - 1)
				return;
			
			if(grid[posX][posY + 1] instanceof Wedge)
			{
				if(Math.random() < GaltonBrett.simulation.getP())
					posX++;
				else
					posX--;
				posY += 2;
				timer = 20;
				timerMax = 20;
			}else
			{
				posY++;
				timer = 5;
				timerMax = 5;
			}
			
			for(Marble marble : GaltonBrett.simulation.marbles)
				if(marble != this && marble.posX == posX && marble.posY == posY)
				{
					posX = oldPosX;
					posY = oldPosY;
					timer = 0;
					timerMax = 0;
				}
		}
	}
}
