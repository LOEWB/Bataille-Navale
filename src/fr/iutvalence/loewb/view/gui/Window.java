package fr.iutvalence.loewb.view.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.iutvalence.loewb.model.battleship.Player;


public class Window extends JFrame
{

	private JSplitPane splitQuit, splitGo, splitJoueurs;
	private JTextField tfJoueur1 = new JTextField("Joueur1");
	private JTextField tfJoueur2 = new JTextField("Joueur2");
	private JButton bQuitter = new JButton("Quitter");
	private JButton bGo = new JButton("GO");

	public Window()
	{
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.start();
		this.placeBoat();
		this.setVisible(true);
	}
	public void start()
	{
		
		JPanel quitter = new JPanel();
		quitter.setPreferredSize(new Dimension(800, 300));
		JPanel go = new JPanel();
		JPanel joueur1 = new JPanel();
		JPanel joueur2 = new JPanel();
		quitter.setBackground(Color.red);
		go.setBackground(Color.blue);
		joueur1.setBackground(Color.white);
		joueur2.setBackground(Color.white);

		splitJoueurs = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, joueur1, joueur2);
		splitJoueurs.setDividerSize(0);
		splitJoueurs.setDividerLocation(this.getWidth()/2);

		splitGo = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitJoueurs, go);
		splitGo.setDividerSize(0);
		splitGo.setDividerLocation(50);

		splitQuit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, quitter, splitGo);
		splitQuit.setDividerSize(0);
		splitQuit.setDividerLocation(380);

		Font police = new Font("Arial", Font.BOLD, 14);
		joueur1.setFont(police);
		joueur1.setPreferredSize(new Dimension(150, 30));
		joueur1.setForeground(Color.BLUE);

		joueur2.setFont(police);
		joueur2.setPreferredSize(new Dimension(150, 30));
		joueur2.setForeground(Color.BLUE);

		GridBagConstraints gridStart = new GridBagConstraints();
		gridStart.gridx = 0;
		gridStart.gridy = 0;
		gridStart.gridheight = 1;
		gridStart.gridwidth = 1;

		quitter.add(bQuitter, gridStart);
		go.add(bGo);
		joueur1.add(tfJoueur1);
		joueur2.add(tfJoueur2);

		this.getContentPane().add(splitQuit);
	}

	public void placeBoat()
	{
		JPanel gridBoatPan = new JPanel();
		JLabel PlayerLabelPan = new JLabel("Joueur 1");
		
		JSplitPane splitGrid = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new GridBoatPan(), new BoatTablePan());
		splitGrid.setDividerLocation(this.getWidth()/4*3);
		splitGrid.setDividerSize(0);
		JSplitPane splitDone = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JLabel("Placez vos bateaux"),new DoneButton());
		splitDone.setDividerLocation(this.getWidth()/4*3);
		splitDone.setDividerSize(0);
		JSplitPane centralSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitGrid,splitDone);
		centralSplit.setDividerLocation(this.getHeight()/5*4);
		centralSplit.setDividerSize(0);
		JSplitPane finalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,PlayerLabelPan,centralSplit);
		finalSplit.setDividerLocation(this.getHeight()/15);
		finalSplit.setDividerSize(0);
		this.setContentPane(finalSplit);
	}
	
	public void play()
	{
		
	}
}
