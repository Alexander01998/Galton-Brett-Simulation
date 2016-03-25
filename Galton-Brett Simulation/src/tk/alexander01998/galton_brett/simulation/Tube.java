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

public class Tube extends Entity
{
	public Tube()
	{
		super(TextureManager.TUBE);
	}
	
	@Override
	public void render(Graphics g, int posX, int posY)
	{
		int dx1 = posX * 64, dy1 = posY * 64;
		int dx2 = dx1 + 64, dy2 =
			dy1 + (GaltonBrett.simulation.getM() - 1) * 64;
		g.drawImage(texture, dx1, dy1, dx2, dy2, 0, 0, 64, 192, null);
		g.drawImage(texture, dx1, dy2, dx2, dy2 + 64, 0, 192, 64, 256, null);
	}
}
