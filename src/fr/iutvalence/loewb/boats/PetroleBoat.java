package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;
/** Defines an AircraftCarrier boat, extension of the class Boat*/
public class PetroleBoat extends Boat
{
	public PetroleBoat()
	{
		this.size = 2;
		this.horizontal = true;
		this.coordinates = new Coordinates(8,0);
		this.placed = false;
		this.healthPoints = this.size;
	}
}
