/*
 * Copyright � 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureManager
{
	public static final BufferedImage BACKGROUND = getTexture("hintergrund");
	public static final BufferedImage MARBLE = getTexture("kugel");
	public static final BufferedImage WEDGE = getTexture("keil");
	public static final BufferedImage TUBE = getTexture("roehre");
	
	private static BufferedImage getTexture(String name)
	{
		try
		{
			return ImageIO.read(TextureManager.class.getClassLoader()
				.getResourceAsStream("textures/" + name + ".png"));
		}catch(IOException e)
		{
			// TODO: error messages
			e.printStackTrace();
		}
		return null;
	}
}
