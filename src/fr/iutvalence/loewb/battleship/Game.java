package fr.iutvalence.loewb.battleship;

import java.util.InputMismatchException;
import java.util.Scanner;
/** Defines a game*/
public class Game 
{
	/**Attribute: the two players*/
	Player p1,p2;

	/**Constructor of the class*/
	public Game()
	{
		this.start();
		this.play();
		this.endGame();
	}

	/**Method: To start and initialize a game*/
	public void start()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("         ---- BATTLECHIP'S ----       ");
		System.out.println("Entrer nom joueur 1 : \n\n");
		String player1Name = sc.nextLine();
		System.out.println("\n\nEntrer nom joueur 2 : \n\n");
		String player2Name = sc.nextLine();

		p1 = new Player(player1Name);
		p2 = new Player(player2Name);
		p1.opponent = p2;
		p2.opponent = p1;
		System.out.println("\n\nA "+p1.getName()+" de placer ses bateaux\n\n");
		this.initBoatGrid(p1);
		System.out.println("\n\nA "+p1.getName()+" de placer ses bateaux\n\n");
		this.initBoatGrid(p2);

	}

	/**Method: To play the game, the players has to hit*/
	public void play()
	{
		while (p1.isAlive() && p2.isAlive())
		{
			boolean hit = false;
			int rowNumber;
			int columnNumber;			
			Scanner sc = new Scanner(System.in);
			System.out.println("\n\n -----  Au tour de "+p1.getName()+"  -----\n\n");
			System.out.println(p1.getCheckerGrid());

			do
			{
				sc = new Scanner(System.in);
				if (!p1.isAlive() || !p2.isAlive() )
					break;
				System.out.println("Entrer le numéro de ligne où frapper : \n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer le numéro de colonne où frapper : \n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				hit = p1.hit(new Coordinates(rowNumber,columnNumber));
				System.out.println(p1.getCheckerGrid());
			} while(hit==true);

			System.out.println("\n\n -----  Au tour de "+p2.getName()+"  -----\n\n");
			System.out.println(p2.getCheckerGrid());

			do
			{
				sc = new Scanner(System.in);
				if (!p1.isAlive() || !p2.isAlive() )
					break;
				System.out.println("Entrer le numéro de ligne où frapper : \n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer le numéro de colonne où frapper : \n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				hit = p2.hit(new Coordinates(rowNumber,columnNumber));
				System.out.println(p2.getCheckerGrid());
			} while(hit==true);
		}
	}

	/** Method: To place then rotate and move all the boats of a player at the beginning of a game
	 * 
	 * @param Player p
	 */
	public void initBoatGrid(Player p)
	{
		Scanner sc = new Scanner(System.in);
		int rowNumber = 0;
		int columnNumber = 0;
		int choice;
		Choice final_choice = Choice.NOTHING;

		//AIRCRAFT CARRIER
		while(!p.getAircraftCarrier().placed)
		{
			sc = new Scanner(System.in);
			System.out.println(p.getBoatGrid());
			System.out.println("Placer le porte-avion (5 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			try
			{
				rowNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			try
			{
				columnNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			p.placeBoat(p.getAircraftCarrier(), new Coordinates(rowNumber,columnNumber));
		}
		while(final_choice!=Choice.NEXT)
		{
			sc = new Scanner(System.in);
			choice=0;
			final_choice=Choice.NOTHING;
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("\n---------------------\n0 - Rotation         |\n1 - Bouger le bateau |\n2 - Bateau suivant   |\n---------------------\n\n");
			try 
			{
				choice = sc.nextInt();
				switch(choice){
				case 0:
					final_choice=Choice.ROTATION;
					break;
				case 1:
					final_choice=Choice.MOVE;
					break;
				case 2:
					final_choice=Choice.NEXT;
					break;
				default:
					break;
				}
			} 
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			if (final_choice==Choice.ROTATION)
			{
				p.rotationBoat(p.getAircraftCarrier());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				p.moveBoat(p.getAircraftCarrier(), new Coordinates(rowNumber,columnNumber));
			}
		}



		//BATTLESHIP
		while(!p.getBattleship().placed)
		{
			sc = new Scanner(System.in);
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le cuirassé (4 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			try
			{
				rowNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			try
			{
				columnNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			p.placeBoat(p.getBattleship(), new Coordinates(rowNumber,columnNumber));
			choice=0;
			final_choice=Choice.NOTHING;
		}
		while(final_choice!=Choice.NEXT)
		{
			sc = new Scanner(System.in);
			choice=0;
			final_choice=Choice.NOTHING;
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("\n---------------------\n0 - Rotation         |\n1 - Bouger le bateau |\n2 - Bateau suivant   |\n---------------------\n\n");
			try 
			{
				choice = sc.nextInt();
				switch(choice){
				case 0:
					final_choice=Choice.ROTATION;
					break;
				case 1:
					final_choice=Choice.MOVE;
					break;
				case 2:
					final_choice=Choice.NEXT;
					break;
				default:
					break;
				}
			} 
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			if (final_choice==Choice.ROTATION)
			{
				p.rotationBoat(p.getBattleship());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				p.moveBoat(p.getBattleship(), new Coordinates(rowNumber,columnNumber));
			}
		}




		//DESTROYER
		while(!p.getDestroyer().placed)
		{
			sc = new Scanner(System.in);
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le destroyer (3 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			try
			{
				rowNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			try
			{
				columnNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			p.placeBoat(p.getDestroyer(), new Coordinates(rowNumber,columnNumber));
			choice=0;	
			final_choice=Choice.NOTHING;
		}
		while(final_choice!=Choice.NEXT)
		{
			sc = new Scanner(System.in);
			choice=0;
			final_choice=Choice.NOTHING;
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("\n---------------------\n0 - Rotation         |\n1 - Bouger le bateau |\n2 - Bateau suivant   |\n---------------------\n\n");
			try 
			{
				choice = sc.nextInt();
				switch(choice){
				case 0:
					final_choice=Choice.ROTATION;
					break;
				case 1:
					final_choice=Choice.MOVE;
					break;
				case 2:
					final_choice=Choice.NEXT;
					break;
				default:
					break;
				}
			} 
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			if (final_choice==Choice.ROTATION)
			{
				p.rotationBoat(p.getDestroyer());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				p.moveBoat(p.getDestroyer(), new Coordinates(rowNumber,columnNumber));
			}
		}




		//PETROLEBOAT
		while(!p.getPetroleBoat().placed)
		{
			sc = new Scanner(System.in);
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le pétrolier (2 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			try
			{
				rowNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			try
			{
				columnNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			p.placeBoat(p.getPetroleBoat(), new Coordinates(rowNumber,columnNumber));
			choice=0;
			final_choice=Choice.NOTHING;
		}
		while(final_choice!=Choice.NEXT)
		{
			sc = new Scanner(System.in);
			choice=0;
			final_choice=Choice.NOTHING;
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("\n---------------------\n0 - Rotation         |\n1 - Bouger le bateau |\n2 - Bateau suivant   |\n---------------------\n\n");
			try 
			{
				choice = sc.nextInt();
				switch(choice){
				case 0:
					final_choice=Choice.ROTATION;
					break;
				case 1:
					final_choice=Choice.MOVE;
					break;
				case 2:
					final_choice=Choice.NEXT;
					break;
				default:
					break;
				}
			} 
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			if (final_choice==Choice.ROTATION)
			{
				p.rotationBoat(p.getPetroleBoat());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				p.moveBoat(p.getPetroleBoat(), new Coordinates(rowNumber,columnNumber));
			}
		}





		//SUBMARINE
		while(!p.getSubmarine().placed)
		{
			sc = new Scanner(System.in);
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le sous-marin (3 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			try
			{
				rowNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			try
			{
				columnNumber = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			p.placeBoat(p.getSubmarine(), new Coordinates(rowNumber,columnNumber));
			choice=0;
			final_choice=Choice.NOTHING;
		}
		while(final_choice!=Choice.NEXT)
		{
			sc = new Scanner(System.in);
			choice=0;
			final_choice=Choice.NOTHING;
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("\n---------------------\n0 - Rotation         |\n1 - Bouger le bateau |\n2 - Terminé          |\n---------------------\n\n");
			try 
			{
				choice = sc.nextInt();
				switch(choice){
				case 0:
					final_choice=Choice.ROTATION;
					break;
				case 1:
					final_choice=Choice.MOVE;
					break;
				case 2:
					final_choice=Choice.NEXT;
					break;
				default:
					break;
				}
			} 
			catch (IllegalArgumentException | InputMismatchException e)
			{
				System.err.println("\nEntrée incorrecte\n");
				continue;
			}
			if (final_choice==Choice.ROTATION)
			{
				p.rotationBoat(p.getSubmarine());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				try
				{
					rowNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				try
				{
					columnNumber = sc.nextInt();
				}
				catch (InputMismatchException e)
				{
					System.err.println("\nEntrée incorrecte\n");
					continue;
				}
				p.moveBoat(p.getSubmarine(), new Coordinates(rowNumber,columnNumber));
			}
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	/** Method: to end a game*/
	public void endGame()
	{
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if(this.p1.isAlive())
			System.out.println("\t\t\t\t"+p1.getName()+" s'est servi du visage de "+p2.getName()+" comme d'un paillasson !\n\n");
		else
			System.out.println("\t\t\t\t"+p2.getName()+" s'est servi du visage de "+p1.getName()+" comme d'un paillasson !\n\n");
	}
}
