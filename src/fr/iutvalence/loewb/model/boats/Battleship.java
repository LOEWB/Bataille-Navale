package fr.iutvalence.loewb.model.boats;

import fr.iutvalence.loewb.model.battleship.Boat;
import fr.iutvalence.loewb.model.battleship.Coordinates;
/** Defines an Battleship boat, extension of the class Boat*/
public class Battleship extends Boat
{
	/** Constructor of the boat*/
	public Battleship()
	{
		this.size = 4;
		this.horizontal = true;
		this.coordinates = new Coordinates(2,0);
		this.placed = false;
		this.healthPoints = this.size;
	}
}
