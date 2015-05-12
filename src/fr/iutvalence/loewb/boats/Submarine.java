package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;
/** Defines an AircraftCarrier boat, extension of the class Boat*/
public class Submarine extends Boat
{
	public Submarine()
	{
		this.size = 3;
		this.horizontal = true;
		this.coordinates = new Coordinates(6,0);
		this.placed = false;
	}
}
