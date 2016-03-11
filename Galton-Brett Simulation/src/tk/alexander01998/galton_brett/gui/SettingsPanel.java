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

public class SettingsPanel extends JPanel
{
	/**
	 * Create the panel.
	 */
	public SettingsPanel()
	{
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblReihenMitKeilen = new JLabel("Reihen mit Keilen (n)");
		springLayout.putConstraint(SpringLayout.NORTH, lblReihenMitKeilen, 13, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblReihenMitKeilen, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblReihenMitKeilen, 159, SpringLayout.WEST, this);
		add(lblReihenMitKeilen);
		
		JLabel lblAnzahlDerKugeln = new JLabel("Anzahl der Kugeln");
		springLayout.putConstraint(SpringLayout.NORTH, lblAnzahlDerKugeln, 10, SpringLayout.SOUTH, lblReihenMitKeilen);
		springLayout.putConstraint(SpringLayout.WEST, lblAnzahlDerKugeln, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblAnzahlDerKugeln, 139, SpringLayout.WEST, this);
		add(lblAnzahlDerKugeln);
		
		JSpinner spinnerKeile = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, spinnerKeile, -3, SpringLayout.NORTH, lblReihenMitKeilen);
		springLayout.putConstraint(SpringLayout.WEST, spinnerKeile, 165, SpringLayout.WEST, this);
		lblReihenMitKeilen.setLabelFor(spinnerKeile);
		spinnerKeile.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(1)));
		add(spinnerKeile);
		
		JSpinner spinnerKugeln = new JSpinner();
		springLayout.putConstraint(SpringLayout.NORTH, spinnerKugeln, 4, SpringLayout.SOUTH, spinnerKeile);
		springLayout.putConstraint(SpringLayout.EAST, spinnerKeile, 0, SpringLayout.EAST, spinnerKugeln);
		springLayout.putConstraint(SpringLayout.WEST, spinnerKugeln, 165, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, spinnerKugeln, -10, SpringLayout.EAST, this);
		lblAnzahlDerKugeln.setLabelFor(spinnerKugeln);
		spinnerKugeln.setModel(new SpinnerNumberModel(new Integer(3), new Integer(1), null, new Integer(1)));
		add(spinnerKugeln);
		
	}
}
