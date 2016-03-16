/*
 * Copyright � 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.simulation;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import tk.alexander01998.galton_brett.GaltonBrett;
import tk.alexander01998.galton_brett.gui.SimulationCanvas;
import tk.alexander01998.galton_brett.gui.TextureManager;

public class Simulation
{
	private boolean running;
	public Entity[][] grid;
	public ArrayList<Marble> marbles = new ArrayList<>();
	public double tickTime, frameTime;
	private float p;
	
	public Simulation(int n, int m, float p)
	{
		this.p = p;
		
		// add wedges
		grid = new Entity[n * 2 + 1][n * 2 + 4];
		for(int y = 0; y < n; y++)
			for(int x = 0; x < y + 1; x++)
				grid[n - y + x * 2][y * 2 + 1] = new Wedge();
		
		// add tubes
		for(int i = 0; i < grid.length; i += 2)
			grid[i][grid[0].length - 4] = new Tube();
		
		// add a marble
		for(int i = 0; i < m; i++)
			marbles.add(new Marble(3, -1));
		
		// set panel size
		Dimension size = new Dimension(grid.length * 64, grid[0].length * 64);
		SimulationCanvas simulationCanvas = GaltonBrett.frame.simulationCanvas;
		simulationCanvas.setSize(size);
		simulationCanvas.setMinimumSize(size);
		simulationCanvas.setPreferredSize(size);
		simulationCanvas.setMaximumSize(size);
	}
	
	public void run()
	{
		running = true;
		long cycleStart, cycleEnd, tickStart, frameStart, lastTick = 0, lastFrame =
			0, sleepTime;
		while(running)
		{
			cycleStart = System.currentTimeMillis();
			
			// tick (20Hz)
			if(cycleStart >= lastTick + 50)
			{
				tickStart = System.nanoTime();
				
				tick();
				
				lastTick = cycleStart;
				tickTime = (System.nanoTime() - tickStart) * 1e-6;
			}
			
			// render (62.5Hz)
			if(cycleStart >= lastFrame + 16)
			{
				frameStart = System.nanoTime();
				
				render((cycleStart - lastTick) / 50F);
				
				lastFrame = cycleStart;
				frameTime = (System.nanoTime() - frameStart) * 1e-6;
			}
			
			// sleep
			cycleEnd = System.currentTimeMillis();
			sleepTime =
				Math.min(lastFrame + 16 - cycleEnd, lastTick + 50 - cycleEnd);
			if(sleepTime > 1)
				try
				{
					Thread.sleep(sleepTime - 1);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
		}
	}
	
	private void tick()
	{
		for(Marble marble : marbles)
			marble.update();
	}
	
	private void render(float partialTicks)
	{
		SimulationCanvas simulationCanvas = GaltonBrett.frame.simulationCanvas;
		BufferStrategy bs = simulationCanvas.getBufferStrategy();
		if(bs == null)
		{
			simulationCanvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		// background
		for(int x = 0; x < simulationCanvas.getWidth(); x += 256)
			for(int y = 0; y < simulationCanvas.getHeight(); y += 256)
				g.drawImage(TextureManager.BACKGROUND, x, y, null);
		
		// marbles
		for(Marble marble : marbles)
			marble.render(g, partialTicks);
		
		// wedges & tubes
		for(int x = 0; x < grid.length; x++)
			for(int y = 0; y < grid[x].length; y++)
			{
				Entity entity = grid[x][y];
				if(entity != null)
					entity.render(g, x, y);
			}
		
		// border
		g.drawRect(0, 0, grid.length * 64, grid[0].length * 64);
		
		g.dispose();
		bs.show();
	}
	
	public float getP()
	{
		return p;
	}
	
	public void stop()
	{
		running = false;
	}
}
