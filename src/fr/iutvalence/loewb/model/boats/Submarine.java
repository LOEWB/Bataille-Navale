package fr.iutvalence.loewb.model.boats;

import fr.iutvalence.loewb.model.battleship.Boat;
import fr.iutvalence.loewb.model.battleship.Coordinates;
/** Defines an Submarine boat, extension of the class Boat*/
public class Submarine extends Boat
{
	/** Constructor of the boat*/
	public Submarine()
	{
		this.size = 3;
		this.horizontal = true;
		this.coordinates = new Coordinates(6,0);
		this.placed = false;
		this.healthPoints = this.size;
	}
}
