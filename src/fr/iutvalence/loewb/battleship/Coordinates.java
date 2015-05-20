package fr.iutvalence.loewb.battleship;
/* TODO package. */
/** Defines a coordinates with too axis X and Y */
public class Coordinates 
{
	/** Attribute: final integer of the X axis of the coordinate */
	private final int axisX;
	/** Variable: final integer of the Y axis of the coordinate */
	private final int axisY;

	/** Constructor: depending on X and Y
	 * 
	 * @param X
	 * @param Y
	 */
	public Coordinates(int X, int Y)
	{
		this.axisX = X;
		this.axisY = Y;
	}

	/** Method: get the X axis of the coordinate
	 * 
	 * @return axisX*/
	public int getAxisX() 
	{
		return axisX;
	}

	/** Method: get the Y axis of the coordinate
	 * 
	 * @return axisY*/
	public int getAxisY() 
	{
		return axisY;
	}    
}
