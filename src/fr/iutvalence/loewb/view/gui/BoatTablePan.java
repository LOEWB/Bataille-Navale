package fr.iutvalence.loewb.view.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoatTablePan extends JPanel
{
	public BoatTablePan()
	{
		this.setLayout(new GridLayout(5,1));
		for(int iNbButton = 0; iNbButton<5;iNbButton++)
		{
			this.add(new JButton(""+iNbButton));
		}
	}
}
