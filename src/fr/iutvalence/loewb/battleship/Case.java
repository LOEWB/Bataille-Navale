package fr.iutvalence.loewb.battleship;

/** Defines a case of a grid. Designed to contain either a part of a boat or a checker */
public class Case 
{

	/** Attribute: boolean which indicates if the case is used or not (either by a part of a boat or a checker) */
	private boolean used = false;
	/** Attribute: boolean which indicates if the case (for a boat grid) is hit or not */
	private boolean hit;
	/** Attribute: the boat placed on this case */
	public Boat boat;
	/** Constructor*/
	public Case() 
	{
		this.used = false;
		this.hit = false;
		this.boat = null;
	}

	/** Method: To know if the case (for a boatgrid)with a boat on it is hit or not
	 * 
	 * @return boolean: hit
	 */
	public boolean isHit() 
	{
		return hit;
	}
	/** Method: To change the state of a hit case*/
	public void changeHitState() 
	{
		this.hit = !hit;
	}

	/** Method: To know if the case is used or not 
	 * 
	 * @return used -> the state of the case
	 */
	public boolean isUsedBool() 
	{
		return this.used;
	}

	/** Method: To use a case by changing its state if it's not used*/
	public void changeState()
	{
		if (this.isUsedBool()==false)
			this.used = true;
		else 
			this.used = false;
	}

	/** Method: To display the state of a case using asciiArt
	 * 
	 * @return a string displaying the state of the case using asciiArt
	 */
	public String toString()
	{
		if(this.isHit())
			return "| O ";
		if (this.isUsedBool()==false)
			return "|   ";
		else return "| X ";
	}
}

