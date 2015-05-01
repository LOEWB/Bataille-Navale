package fr.iutvalence.loewb.battleship;

/** Small application initializing a player, moving a boat, and displaying it on the console*/
public class Game 
{	
	/** Application entry point*/
	public static void main (String args[])
	{
		Player p1 = new Player("Joueur 1",1);
		p1.boatGrid.rotationBoat(p1.boatGrid.getFleet()[2]);
		//this move is possible so it's done
		p1.boatGrid.moveBoat(p1.boatGrid.getFleet()[2], new Coordinates(0,9));
		//this move is impossible because there is another boat next to it. So nothing is done.
		p1.boatGrid.moveBoat(p1.boatGrid.getFleet()[2], new Coordinates(5,3));
		System.out.println(p1.getBoatGrid());
	}
}
