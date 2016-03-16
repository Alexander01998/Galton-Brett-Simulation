/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import tk.alexander01998.galton_brett.GaltonBrett;

public class SettingsPanel extends JPanel
{
	/**
	 * Create the panel.
	 */
	public SettingsPanel()
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblN = new JLabel("Reihen mit Keilen (n)");
		springLayout.putConstraint(SpringLayout.NORTH, lblN, 13,
			SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblN, 10,
			SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblN, 159,
			SpringLayout.WEST, this);
		add(lblN);
		
		JLabel lblM = new JLabel("Anzahl der Kugeln");
		springLayout.putConstraint(SpringLayout.NORTH, lblM, 10,
			SpringLayout.SOUTH, lblN);
		springLayout.putConstraint(SpringLayout.WEST, lblM, 10,
			SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblM, 139,
			SpringLayout.WEST, this);
		add(lblM);
		
		JSpinner spinnerN = new JSpinner();
		spinnerN.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				GaltonBrett.simulation.setN((int)spinnerN.getValue());
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, spinnerN, -3,
			SpringLayout.NORTH, lblN);
		springLayout.putConstraint(SpringLayout.WEST, spinnerN, 165,
			SpringLayout.WEST, this);
		lblN.setLabelFor(spinnerN);
		spinnerN.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getN()), new Integer(1), null,
			new Integer(1)));
		add(spinnerN);
		
		JSpinner spinnerM = new JSpinner();
		spinnerM.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				GaltonBrett.simulation.setM((int)spinnerM.getValue());
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, spinnerM, 4,
			SpringLayout.SOUTH, spinnerN);
		springLayout.putConstraint(SpringLayout.EAST, spinnerN, 0,
			SpringLayout.EAST, spinnerM);
		springLayout.putConstraint(SpringLayout.WEST, spinnerM, 165,
			SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, spinnerM, -10,
			SpringLayout.EAST, this);
		lblM.setLabelFor(spinnerM);
		spinnerM.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getM()), new Integer(1), null,
			new Integer(1)));
		add(spinnerM);
		
	}
}
