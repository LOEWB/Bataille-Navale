package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;

public class Submarine extends Boat
{
	public Submarine()
	{
		this.size = 3;
		this.horizontal = true;
		this.coordinates = new Coordinates(6,0);
	}
}
