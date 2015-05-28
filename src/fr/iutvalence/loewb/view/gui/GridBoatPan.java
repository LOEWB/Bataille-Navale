package fr.iutvalence.loewb.view.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridBoatPan extends JPanel
{
	public GridBoatPan()
	{
		this.setLayout(new GridLayout(10,10));
		for(int iNbButton = 0; iNbButton<100;iNbButton++)
		{
			this.add(new JButton());
		}
	}
}
