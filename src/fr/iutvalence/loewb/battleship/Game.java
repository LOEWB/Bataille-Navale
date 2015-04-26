package fr.iutvalence.loewb.battleship;

/** Small application initializing a player, moving a boat, and displaying it on the console*/
public class Game 
{	
	/** Application entry point*/
	public static void main (String args[])
	{
		Player p1 = new Player("Joueur 1",1);
		p1.boatGrid.moveBoat(p1.boatGrid.getFleet()[2], false, new Coordinates(4,6));
		System.out.println(p1.getBoatGrid());
	}
}
