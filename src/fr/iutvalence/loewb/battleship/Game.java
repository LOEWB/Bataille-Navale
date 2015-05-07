package fr.iutvalence.loewb.battleship;

/** Small application initializing a player, moving a boat, and displaying it on the console*/
public class Game 
{	
	/** Application entry point*/
	public static void main (String args[])
	{
		Player p1 = new Player("Joueur 1",1);
		p1.placeBoat(p1.getAircraftCarrier(), new Coordinates(0,0));
		//p1.placeBoat(p1.getBattleship(), new Coordinates(2,0));
		//p1.placeBoat(p1.getDestroyer(), new Coordinates(4,0));
		//p1.placeBoat(p1.getPetroleBoat(), new Coordinates(6,0));
		//p1.placeBoat(p1.getSubmarine(), new Coordinates(8,0));
		//p1.moveBoat(p1.getDestroyer(), new Coordinates (4,7));
		//p1.rotationBoat(p1.getDestroyer());
		//this move is possible so it's done
		//this move is impossible because there is another boat next to it. So nothing is done.
		System.out.println(p1.getBoatGrid());
	}
}
