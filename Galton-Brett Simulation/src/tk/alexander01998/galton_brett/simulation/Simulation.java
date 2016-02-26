/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.simulation;

public class Simulation
{
	private boolean running;
	private Entity[][] grid;
	
	public Simulation(int n)
	{
		grid = new Entity[n + 1][n * 2 + 4];
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < y + 1; x++)
			{
				grid[n - y + x * 2][y * 2 + 1] = new Wedge();
			}
		}
	}
	
	private void run()
	{
		running = true;
		long frameStart, sleepTime, lastTick = 0;
		while(running)
		{
			frameStart = System.currentTimeMillis();
			
			// tick (20Hz)
			if(frameStart >= lastTick + 50)
			{
				runTick();
				lastTick = frameStart;
			}
			
			// render (60Hz)
			float partialTicks = frameStart - lastTick / 50;
			// TODO: repaint panel
			
			sleepTime = frameStart + 16 - System.currentTimeMillis();
			if(sleepTime > 0)
				try
				{
					Thread.sleep(sleepTime);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
		}
	}
	
	private void runTick()
	{	
		
	}
}
