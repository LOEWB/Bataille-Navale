package fr.iutvalence.loewb.battleship;

import java.util.Scanner;

public class Game 
{
	
	public Game()
	{
		this.start();
	}
	
	public void start()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("             BATTLECHIP'S          ");
		System.out.println("Entrer nom joueur 1 : \n\n");
		String player1Name = sc.nextLine();
		System.out.println("\n\nEntrer nom joueur 2 : \n\n");
		String player2Name = sc.nextLine();
		
		Player p1 = new Player(player1Name,1);
		Player p2 = new Player(player2Name,2);
		p1.opponent = p2;
		p2.opponent = p1;
		System.out.println("\n\n Joueur 1 place ses bateaux\n\n");
		this.initBoatGrid(p1);
		this.initBoatGrid(p2);
	
	}
	
	public void initBoatGrid(Player p)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(p.getBoatGrid());
		System.out.println("Placer le porte-avion (5 cases)");
		System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
		int rowNumber = sc.nextInt();
		System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
		int columnNumber = sc.nextInt();
		p.placeBoat(p.getAircraftCarrier(), new Coordinates(rowNumber,columnNumber));
		System.out.println("\n"+p.getBoatGrid());
		System.out.println("\nVoulez vous faire une rotation ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			p.rotationBoat(p.getAircraftCarrier());
			System.out.println("\n"+p.getBoatGrid());
		}
		System.out.println("\nVoulez vous deplacer le bateau ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
			p.moveBoat(p.getAircraftCarrier(), new Coordinates(rowNumber,columnNumber));
		}
		
		
		System.out.println("Placer le cuirassé (4 cases)");
		System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
		rowNumber = sc.nextInt();
		System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
		columnNumber = sc.nextInt();
		p.placeBoat(p.getBattleship(), new Coordinates(rowNumber,columnNumber));
		System.out.println("\n"+p.getBoatGrid());
		System.out.println("\nVoulez vous faire une rotation ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			p.rotationBoat(p.getBattleship());
			System.out.println("\n"+p.getBoatGrid());
		}
		System.out.println("\nVoulez vous deplacer le bateau ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
			p.moveBoat(p.getBattleship(), new Coordinates(rowNumber,columnNumber));
		}
		
		
		System.out.println("Placer le destroyer (3 cases)");
		System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
		rowNumber = sc.nextInt();
		System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
		columnNumber = sc.nextInt();
		p.placeBoat(p.getDestroyer(), new Coordinates(rowNumber,columnNumber));
		System.out.println("\n"+p.getBoatGrid());
		System.out.println("\nVoulez vous faire une rotation ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			p.rotationBoat(p.getDestroyer());
			System.out.println("\n"+p.getBoatGrid());
		}
		System.out.println("\nVoulez vous deplacer le bateau ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
			p.moveBoat(p.getDestroyer(), new Coordinates(rowNumber,columnNumber));
		}
		
		
		System.out.println("Placer le sous-marin (3 cases)");
		System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
		rowNumber = sc.nextInt();
		System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
		columnNumber = sc.nextInt();
		p.placeBoat(p.getSubmarine(), new Coordinates(rowNumber,columnNumber));
		System.out.println("\n"+p.getBoatGrid());
		System.out.println("\nVoulez vous faire une rotation ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			p.rotationBoat(p.getSubmarine());
			System.out.println("\n"+p.getBoatGrid());
		}
		System.out.println("\nVoulez vous deplacer le bateau ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
			p.moveBoat(p.getSubmarine(), new Coordinates(rowNumber,columnNumber));
		}
		

		System.out.println("Placer le pétrolier (2 cases)");
		System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
		rowNumber = sc.nextInt();
		System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
		columnNumber = sc.nextInt();
		p.placeBoat(p.getPetroleBoat(), new Coordinates(rowNumber,columnNumber));
		System.out.println("\n"+p.getBoatGrid());
		System.out.println("\nVoulez vous faire une rotation ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			p.rotationBoat(p.getPetroleBoat());
			System.out.println("\n"+p.getBoatGrid());
		}
		System.out.println("\nVoulez vous deplacer le bateau ?\n0 Pour non\n1 Pour oui\n");
		if (sc.nextInt()==1)
		{
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
			p.moveBoat(p.getPetroleBoat(), new Coordinates(rowNumber,columnNumber));
		}
		
		
	}
}
