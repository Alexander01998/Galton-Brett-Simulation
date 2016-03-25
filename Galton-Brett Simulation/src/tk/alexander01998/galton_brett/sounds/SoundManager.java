/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundManager
{
	public static final Clip MARBLE_ON_WOOD = getSound("kugel-auf-holz");
	public static final Clip MARBLE_ON_GLASS = getSound("kugel-auf-glas");
	public static final Clip MARBLE_ON_MARBLE = getSound("kugel-auf-kugel");
	
	public static void play(Clip sound)
	{
		if(sound == null)
			return;
		
		sound.stop();
		sound.setFramePosition(0);
		sound.start();
	}
	
	private static Clip getSound(String name)
	{
		try
		{
			AudioInputStream input =
				AudioSystem.getAudioInputStream(SoundManager.class
					.getClassLoader().getResource("sounds/" + name + ".wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(input);
			return clip;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
