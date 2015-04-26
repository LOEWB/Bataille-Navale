package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;

public class PetroleBoat extends Boat
{
	public PetroleBoat()
	{
		this.size = 2;
		this.horizontal = true;
		this.coordinates = new Coordinates(8,0);
	}
}
