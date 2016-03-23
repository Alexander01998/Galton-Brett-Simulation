/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tk.alexander01998.galton_brett.GaltonBrett;

public class SettingsPanel extends JPanel
{
	/**
	 * Create the panel.
	 */
	public SettingsPanel()
	{
		setForeground(SystemColor.textHighlight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{156, 0, 0};
		gridBagLayout.rowHeights = new int[]{26, 0, 26, 0};
		gridBagLayout.columnWeights =
			new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights =
			new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblM =
			new JLabel(
				"<html>Anzahl der Kugeln <code><font size=5>m</font></code>");
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 0;
		gbc_lblM.gridy = 0;
		add(lblM, gbc_lblM);
		
		JSpinner spinnerM = new JSpinner();
		lblM.setLabelFor(spinnerM);
		spinnerM.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				GaltonBrett.simulation.setM((int)spinnerM.getValue());
			}
		});
		spinnerM.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getM()), new Integer(1), null,
			new Integer(1)));
		GridBagConstraints gbc_spinnerM = new GridBagConstraints();
		gbc_spinnerM.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerM.anchor = GridBagConstraints.NORTH;
		gbc_spinnerM.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerM.gridx = 1;
		gbc_spinnerM.gridy = 0;
		add(spinnerM, gbc_spinnerM);
		
		JSpinner spinnerP = new JSpinner();
		spinnerP.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				GaltonBrett.simulation.setP((float)spinnerP.getValue());
			}
		});
		
		JSpinner spinnerN = new JSpinner();
		spinnerN.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				GaltonBrett.simulation.setN((int)spinnerN.getValue());
			}
		});
		
		JLabel lblN =
			new JLabel(
				"<html>Reihen mit Keilen <code><font size=5>n</font></code>");
		lblN.setLabelFor(spinnerN);
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 0;
		gbc_lblN.gridy = 1;
		add(lblN, gbc_lblN);
		spinnerN.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getN()), new Integer(1), null,
			new Integer(1)));
		GridBagConstraints gbc_spinnerN = new GridBagConstraints();
		gbc_spinnerN.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerN.anchor = GridBagConstraints.NORTH;
		gbc_spinnerN.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerN.gridx = 1;
		gbc_spinnerN.gridy = 1;
		add(spinnerN, gbc_spinnerN);
		
		JLabel lblP =
			new JLabel(
				"<html>Wahrscheinlichkeit <code><font size=5>p</font></code>");
		lblP.setLabelFor(spinnerP);
		GridBagConstraints gbc_lblP = new GridBagConstraints();
		gbc_lblP.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblP.insets = new Insets(0, 0, 0, 5);
		gbc_lblP.gridx = 0;
		gbc_lblP.gridy = 2;
		add(lblP, gbc_lblP);
		spinnerP.setModel(new SpinnerNumberModel(new Float(0.5F),
			new Float(0F), new Float(1F), new Float(0.05F)));
		GridBagConstraints gbc_spinnerP = new GridBagConstraints();
		gbc_spinnerP.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerP.anchor = GridBagConstraints.NORTH;
		gbc_spinnerP.gridx = 1;
		gbc_spinnerP.gridy = 2;
		add(spinnerP, gbc_spinnerP);
	}
}
