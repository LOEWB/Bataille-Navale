package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;
/** Defines an AircraftCarrier boat, extension of the class Boat*/
public class Destroyer extends Boat
{
	public Destroyer()
	{
		this.size = 3;
		this.horizontal = true;
		this.coordinates = new Coordinates(4,0);
		this.placed = false;
	}
}
