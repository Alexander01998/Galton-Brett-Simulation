/*
 * Copyright � 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett;

import javax.swing.UIManager;

import tk.alexander01998.galton_brett.gui.MainFrame;
import tk.alexander01998.galton_brett.simulation.Simulation;

public class GaltonBrett
{
	public static final String VERSION = "1.0";
	public static MainFrame frame;
	public static Simulation simulation;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		try
		{
			simulation = new Simulation();
			frame = new MainFrame();
			frame.setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
