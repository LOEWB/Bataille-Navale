package fr.iutvalence.loewb.model.battleship;


/** Defines an abstract boat */
public abstract class Boat 
{
	/** Attribute: the size of the boat in a number(integer) of cases */
	protected int size;
	/** Attribute: boolean which defines the orientation of the boat */
	protected boolean horizontal;
	/** Attribute: boolean which defines if the boat is already placed or not on the boat grid */
	public boolean placed;
	/** Attribute: the coordinates of the first part of the boat*/
	protected Coordinates coordinates;	
	/** Attribute: the health points number (integer)*/
	protected int healthPoints;

	/** Method: To get the size of the boat
	 * 
	 * @return its size
	 */
	public int getSize() 
	{
		return size;
	}
	/** Method: To get the orientation of the boat
	 * 
	 * @return its orientation (true for horizontal...)
	 */
	public boolean isHorizontal() 
	{
		return horizontal;
	}
	/** Method: To set the orientation of the boat
	 * 
	 * @param its orientation (true for horizontal...)
	 */
	public void setHorizontal(boolean horizontal) 
	{
		this.horizontal = horizontal;
	}
	/** Method: To get the coordinates of the boat
	 * 
	 * @return its coordinates
	 */
	public Coordinates getCoordinates() 
	{
		return coordinates;
	}
	/** Method: To set the coordinates of the boat
	 * 
	 * @param its coordinates
	 */
	public void setCoordinates(Coordinates coordinates) 
	{
		this.coordinates = coordinates;
	}
	/** Method: to get the health points of the boat
	 * 
	 * @return its healthPoints
	 */
	public int getHealthPoints()
	{
		return healthPoints;
	}
	/**Method: to check if the boat is dead or not
	 * 
	 * @return boolean dead or not
	 */
	public boolean isDead()
	{
		if (this.healthPoints == 0)
			return true;
		return false;
	}
}
