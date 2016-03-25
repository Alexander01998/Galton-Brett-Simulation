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

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import tk.alexander01998.galton_brett.GaltonBrett;
import tk.alexander01998.galton_brett.simulation.Simulation;

public class SettingsPanel extends JPanel
{
	private JSpinner spinnerN;
	private JSpinner spinnerP;
	private JSpinner spinnerM;
	private JSpinner spinnerH;
	private JCheckBox chckbxSounds;
	
	/**
	 * Create the panel.
	 */
	public SettingsPanel()
	{
		setForeground(SystemColor.textHighlight);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{156, 128, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 26, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights =
			new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		spinnerN = new JSpinner();
		
		JLabel lblN =
			new JLabel(
				"<html>Reihen mit Keilen <code><font size=5>n</font></code>");
		lblN.setLabelFor(spinnerN);
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblN.insets = new Insets(0, 0, 5, 5);
		gbc_lblN.gridx = 0;
		gbc_lblN.gridy = 0;
		add(lblN, gbc_lblN);
		spinnerN.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getN()), new Integer(1), null,
			new Integer(1)));
		GridBagConstraints gbc_spinnerN = new GridBagConstraints();
		gbc_spinnerN.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerN.anchor = GridBagConstraints.NORTH;
		gbc_spinnerN.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerN.gridx = 1;
		gbc_spinnerN.gridy = 0;
		add(spinnerN, gbc_spinnerN);
		
		JLabel lblP =
			new JLabel("<html>Neigung <code><font size=5>p</font></code>");
		GridBagConstraints gbc_lblP = new GridBagConstraints();
		gbc_lblP.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblP.insets = new Insets(0, 0, 5, 5);
		gbc_lblP.gridx = 0;
		gbc_lblP.gridy = 1;
		add(lblP, gbc_lblP);
		
		spinnerP = new JSpinner();
		lblP.setLabelFor(spinnerP);
		spinnerP.setModel(new SpinnerNumberModel(new Float(
			GaltonBrett.simulation.getP()), new Float(0F), new Float(1F),
			new Float(0.05F)));
		GridBagConstraints gbc_spinnerP = new GridBagConstraints();
		gbc_spinnerP.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerP.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerP.anchor = GridBagConstraints.NORTH;
		gbc_spinnerP.gridx = 1;
		gbc_spinnerP.gridy = 1;
		add(spinnerP, gbc_spinnerP);
		
		JLabel lblM =
			new JLabel(
				"<html>Anzahl der Kugeln <code><font size=5>m</font></code>");
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 0;
		gbc_lblM.gridy = 2;
		add(lblM, gbc_lblM);
		
		spinnerM = new JSpinner();
		spinnerM.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getM()), new Integer(1), null,
			new Integer(1)));
		GridBagConstraints gbc_spinnerM = new GridBagConstraints();
		gbc_spinnerM.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerM.anchor = GridBagConstraints.NORTH;
		gbc_spinnerM.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerM.gridx = 1;
		gbc_spinnerM.gridy = 2;
		add(spinnerM, gbc_spinnerM);
		lblM.setLabelFor(spinnerM);
		
		JLabel lblH =
			new JLabel(
				"<html>H\u00F6he der R\u00F6hren <code><font size=5>h</font></code>");
		GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 0;
		gbc_lblH.gridy = 3;
		add(lblH, gbc_lblH);
		
		spinnerH = new JSpinner();
		lblH.setLabelFor(spinnerH);
		spinnerH.setModel(new SpinnerNumberModel(new Integer(
			GaltonBrett.simulation.getH()), new Integer(1), null,
			new Integer(1)));
		GridBagConstraints gbc_spinnerH = new GridBagConstraints();
		gbc_spinnerH.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerH.anchor = GridBagConstraints.NORTH;
		gbc_spinnerH.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerH.gridx = 1;
		gbc_spinnerH.gridy = 3;
		add(spinnerH, gbc_spinnerH);
		
		chckbxSounds = new JCheckBox("Sounds");
		GridBagConstraints gbc_chckbxSounds = new GridBagConstraints();
		gbc_chckbxSounds.gridwidth = 2;
		gbc_chckbxSounds.anchor = GridBagConstraints.WEST;
		gbc_chckbxSounds.gridx = 0;
		gbc_chckbxSounds.gridy = 4;
		add(chckbxSounds, gbc_chckbxSounds);
	}
	
	public void updateSettings()
	{
		Simulation simulation = GaltonBrett.simulation;
		simulation.setN((int)spinnerN.getValue());
		simulation.setP((float)spinnerP.getValue());
		simulation.setM((int)spinnerM.getValue());
		simulation.setH((int)spinnerH.getValue());
		simulation.setSoundsEnabled(chckbxSounds.isSelected());
	}
}
