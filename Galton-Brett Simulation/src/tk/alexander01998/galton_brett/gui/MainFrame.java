/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame
{
	public SimulationCanvas simulationCanvas;
	
	/**
	 * Create the frame.
	 */
	public MainFrame()
	{
		setTitle("Galton-Brett Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane
			.addTab(
				"Einstellungen\r\n",
				new ImageIcon(
					MainFrame.class
						.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-information.png")),
				panel, null);
		
		simulationCanvas = new SimulationCanvas();
		tabbedPane
			.addTab(
				"Simulation",
				new ImageIcon(
					MainFrame.class
						.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-error.png")),
				simulationCanvas, null);
	}
}
