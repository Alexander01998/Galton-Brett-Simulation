/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tk.alexander01998.galton_brett.GaltonBrett;

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
		setBounds(100, 100, 800, 800);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				if(tabbedPane.getSelectedIndex() == 1)
					GaltonBrett.simulation.start();
				else
					GaltonBrett.simulation.stop();
			}
		});
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		SettingsPanel settingsPanel = new SettingsPanel();
		tabbedPane
			.addTab(
				"Einstellungen\r\n",
				(Icon) null,
				settingsPanel, null);
		
		simulationCanvas = new SimulationCanvas();
		tabbedPane
			.addTab(
				"Simulation",
				(Icon) null,
				simulationCanvas, null);
		
		HelpPanel helpPanel = new HelpPanel();
		tabbedPane
			.addTab(
				"Hilfe",
				(Icon) null,
				helpPanel, null);
	}
}
