/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.sounds;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

@SuppressWarnings("restriction")
public class SoundManager
{
	public static final Media KUGEL_AUF_HOLZ = getSound("kugel-auf-holz");
	public static final Media KUGEL_AUF_GLAS = getSound("kugel-auf-glas");
	public static final Media KUGEL_AUF_KUGEL = getSound("kugel-auf-kugel");
	
	public static void initialize()
	{
		// initialize JavaFX
		new JFXPanel();
	}
	
	public static void play(Media sound)
	{
		MediaPlayer player = new MediaPlayer(sound);
		player.play();
	}
	
	private static Media getSound(String name)
	{
		return new Media(SoundManager.class.getClassLoader()
			.getResource("sounds/" + name + ".mp3").toString());
	}
}
