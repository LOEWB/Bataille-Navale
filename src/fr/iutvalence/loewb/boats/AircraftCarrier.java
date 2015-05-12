package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;
/** Defines an AircraftCarrier boat, extension of the class Boat*/
public class AircraftCarrier extends Boat
{
	public AircraftCarrier()
	{
		this.size = 5;
		this.horizontal = true;
		this.coordinates = new Coordinates(0,0);
		this.placed = false;
	}
}
