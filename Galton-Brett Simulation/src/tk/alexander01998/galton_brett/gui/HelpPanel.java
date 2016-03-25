/*
 * Copyright © 2016 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.alexander01998.galton_brett.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HelpPanel extends JPanel
{
	/**
	 * Create the panel.
	 */
	public HelpPanel()
	{
		setLayout(new BorderLayout(0, 0));
		JLabel lblHelp = new JLabel("<html>\r\n<p>Das Galtonbrett ist ein Versuch zur Visualisierung der Gau\u00DFschen Glockenkurve in binominalverteilten Zufallsexperimenten.\r\n<p>\r\n<p>Auf dem Brett werden <code><font size=5>n</font></code> Reihen mit Keilen angebracht, wobei sich in der ersten (obersten) Reihe ein Keil befindet, in der zweiten Reihe zwei Keile und so weiter, und schlie\u00DFlich in der <code><font size=5>n</font></code>ten (untersten) Reihe <code><font size=5>n</font></code> Keile. Durch diese Anordnung der Keile ergibt sich ein gleichseitiges Dreieck.\r\n<p>\r\n<p>Unter der <code><font size=5>n</font></code>ten Reihe mit Keilen befinden sich <code><font size=5>n+1</font></code> R\u00F6hren, die von 0 bis <code><font size=5>n</font></code> durchnummeriert sind.\r\n<p>\r\n<p>Nun werden nacheinander Kugeln auf den obersten Keil fallengelassen, sodass sie an den Keilen herunterrollen und schlie\u00DFlich in den R\u00F6hren landen. Jede Kugel wird an jedem Keil mit der Wahrscheinlichkeit <code><font size=5>p</font></code> nach rechts abgelenkt. Die Nummer <code><font size=5>X<font size=2>n</font></code> der R\u00F6hre, in der die Kugel letztendlich landet, ist mit den Parametern <code><font size=5>n</font></code> und <code><font size=5>p</font></code> binomial verteilt. Es gilt:\r\n<table cellspacing=0 cellpadding=0>\r\n<tr><td rowspan=2><code><font size=5>P(X<td><td rowspan=2><code><font size=5>&nbsp;= k) = (<td><code><font size=5>n<td rowspan=2><code><font size=5>)&nbsp;* p<td><code><font size=5>k<td rowspan=2><code><font size=5>&nbsp;* (1 - p)<td><code><font size=5>n - k\r\n<tr><td><code><font size=5>n<td><code><font size=5>k<td><td>\r\n</table>");
		add(lblHelp, BorderLayout.NORTH);
		lblHelp.setVerticalAlignment(SwingConstants.TOP);
		
	}
}
