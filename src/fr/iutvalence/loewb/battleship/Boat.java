package fr.iutvalence.loewb.battleship;

public abstract class Boat 
{
	protected int size;
	protected boolean horizontal;
	/** Variable: the coordinates of the first part of the boat*/
	protected Coordinates coordinates;	
	
	public int getSize() {
		return size;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
}
