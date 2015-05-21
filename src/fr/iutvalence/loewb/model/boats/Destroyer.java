package fr.iutvalence.loewb.model.boats;

import fr.iutvalence.loewb.model.battleship.Boat;
import fr.iutvalence.loewb.model.battleship.Coordinates;
/** Defines an Destroyer boat, extension of the class Boat*/
public class Destroyer extends Boat
{
	/** Constructor of the boat*/
	public Destroyer()
	{
		this.size = 3;
		this.horizontal = true;
		this.coordinates = new Coordinates(4,0);
		this.placed = false;
		this.healthPoints = this.size;
	}
}
