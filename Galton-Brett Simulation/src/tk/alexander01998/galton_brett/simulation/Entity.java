/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.simulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity
{
	protected final BufferedImage texture;
	
	public Entity(BufferedImage texture)
	{
		this.texture = texture;
	}
	
	public void render(Graphics g, int posX, int posY)
	{
		g.drawImage(texture, posX * 64, posY * 64, null);
	}
}
