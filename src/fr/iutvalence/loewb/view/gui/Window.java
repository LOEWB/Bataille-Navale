package fr.iutvalence.loewb.view.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class Window extends JFrame
{

  private JSplitPane splitQuitter, splitGo, splitJoueurs;

  private JTextField tfJoueur1 = new JTextField("Joueur1");
  private JTextField tfJoueur2 = new JTextField("Joueur2");
  private JButton bQuitter = new JButton("Quitter");
  private JButton bGo = new JButton("GO");

  public Window()
  {

    this.setSize(1000, 700);
    this.setLocationRelativeTo(null);

    JPanel quitter = new JPanel();
    quitter.setPreferredSize(new Dimension(1000, 400));
    JPanel go = new JPanel();
    JPanel joueur1 = new JPanel();
    JPanel joueur2 = new JPanel();
    quitter.setBackground(Color.red);
    go.setBackground(Color.blue);
    joueur1.setBackground(Color.white);
    joueur2.setBackground(Color.white);

    splitJoueurs = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, joueur1, joueur2);
    splitJoueurs.setDividerSize(1);
    splitJoueurs.setDividerLocation(500);

    splitGo = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitJoueurs, go);
    splitGo.setDividerSize(0);
    splitGo.setDividerLocation(100);

    splitQuitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT, quitter, splitGo);
    splitQuitter.setDividerSize(0);
    splitQuitter.setDividerLocation(400);

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

    this.getContentPane().add(splitQuitter);
    this.setVisible(true);

  }
}
