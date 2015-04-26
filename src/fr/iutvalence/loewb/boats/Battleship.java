package fr.iutvalence.loewb.boats;

import fr.iutvalence.loewb.battleship.Boat;
import fr.iutvalence.loewb.battleship.Coordinates;

public class Battleship extends Boat
{
	public Battleship()
	{
		this.size = 4;
		this.horizontal = true;
		this.coordinates = new Coordinates(2,0);
	}
}
