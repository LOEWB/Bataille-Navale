package fr.iutvalence.loewb.model.boats;

import fr.iutvalence.loewb.model.battleship.Boat;
import fr.iutvalence.loewb.model.battleship.Coordinates;
/** Defines an AircraftCarrier boat, extension of the class Boat*/
public class AircraftCarrier extends Boat
{
	/** Constructor of the boat*/
	public AircraftCarrier()
	{
		this.size = 5;
		this.horizontal = true;
		this.coordinates = new Coordinates(0,0);
		this.placed = false;
		this.healthPoints = this.size;
	}
}
