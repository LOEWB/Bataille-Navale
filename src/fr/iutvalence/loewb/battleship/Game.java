package fr.iutvalence.loewb.battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game 
{
	Player p1,p2;

	public Game()
	{
		this.start();
		this.play();
		this.endGame();
	}

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
				if (!p1.isAlive() || !p2.isAlive() )
					break;
				System.out.println("Entrer le numéro de ligne où frapper : \n\n");
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer le numéro de colonne où frapper : \n\n");
				columnNumber = sc.nextInt();
				hit = p1.hit(new Coordinates(rowNumber,columnNumber));
				System.out.println(p1.getCheckerGrid());
			} while(hit==true);

			System.out.println("\n\n -----  Au tour de "+p2.getName()+"  -----\n\n");
			System.out.println(p2.getCheckerGrid());

			do
			{
				if (!p1.isAlive() || !p2.isAlive() )
					break;
				System.out.println("Entrer le numéro de ligne où frapper : \n\n");
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer le numéro de colonne où frapper : \n\n");
				columnNumber = sc.nextInt();
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



		while(!p.getAircraftCarrier().placed)
		{
			System.out.println(p.getBoatGrid());
			System.out.println("Placer le porte-avion (5 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
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
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				columnNumber = sc.nextInt();
				p.moveBoat(p.getAircraftCarrier(), new Coordinates(rowNumber,columnNumber));
			}
		}







		while(!p.getBattleship().placed)
		{
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le cuirassé (4 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
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
			System.out.println("\n0 - Rotation\n1 - Bouger le bateau\n2 - Bateau suivant");
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
				System.out.println("\n"+p.getBoatGrid());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				columnNumber = sc.nextInt();
				p.moveBoat(p.getAircraftCarrier(), new Coordinates(rowNumber,columnNumber));
				System.out.println("\n"+p.getBattleship());
			}
		}






		while(!p.getDestroyer().placed)
		{
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le destroyer (3 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
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
				System.out.println("\n"+p.getBoatGrid());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				columnNumber = sc.nextInt();
				p.moveBoat(p.getDestroyer(), new Coordinates(rowNumber,columnNumber));
				System.out.println("\n"+p.getBoatGrid());
			}
		}





		while(!p.getPetroleBoat().placed)
		{
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le pétrolier (2 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
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
				System.out.println("\n"+p.getBoatGrid());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				columnNumber = sc.nextInt();
				p.moveBoat(p.getPetroleBoat(), new Coordinates(rowNumber,columnNumber));
				System.out.println("\n"+p.getBoatGrid());
			}
		}







		while(!p.getSubmarine().placed)
		{
			System.out.println("\n"+p.getBoatGrid());
			System.out.println("Placer le sous-marin (3 cases)");
			System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
			rowNumber = sc.nextInt();
			System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
			columnNumber = sc.nextInt();
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
				System.out.println("\n"+p.getBoatGrid());
			}
			if (final_choice==Choice.MOVE)
			{
				System.out.println("\n\nEntrer numéro de ligne (0-9)\n\n");
				rowNumber = sc.nextInt();
				System.out.println("\n\nEntrer numéro de colonne (0-9)\n\n");
				columnNumber = sc.nextInt();
				p.moveBoat(p.getSubmarine(), new Coordinates(rowNumber,columnNumber));
				System.out.println("\n"+p.getBoatGrid());
			}
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public void endGame()
	{
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if(this.p1.isAlive())
			System.out.println("\t\t\t\t"+p1.getName()+" s'est servi du visage de "+p2.getName()+" comme d'un paillasson !\n\n");
		else
			System.out.println("\t\t\t\t"+p2.getName()+" s'est servi du visage de "+p1.getName()+" comme d'un paillasson !\n\n");
	}
}
