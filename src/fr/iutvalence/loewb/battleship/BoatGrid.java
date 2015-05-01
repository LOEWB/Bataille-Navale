package fr.iutvalence.loewb.battleship;

import fr.iutvalence.loewb.boats.AircraftCarrier;
import fr.iutvalence.loewb.boats.Battleship;
import fr.iutvalence.loewb.boats.Destroyer;
import fr.iutvalence.loewb.boats.PetroleBoat;
import fr.iutvalence.loewb.boats.Submarine;
/** Defines the grid extending the class Grid, which is designed to contain boats */
public class BoatGrid extends Grid
{
	/** Variable: table of 5 boats which is the fleet of this current player*/
    private Boat fleet [] = new Boat [5];
    
    
    /** Constructor: The Grid depending on its type 
     * 
     * @param type
     */
    public BoatGrid()
    {
    	createGrid();
    	fillFleet();
        for(int i = 0; i<fleet.length;i++)
        	placeBoat(fleet[i]);
    }
    
    
    /** Method: To fill the fleet table with instantiation of the 5 boats*/
    public void fillFleet()
    {
    	fleet[0] = new AircraftCarrier();
    	fleet[1] = new Battleship();
    	fleet[2] = new Submarine();
    	fleet[3] = new Destroyer();
    	fleet[4] = new PetroleBoat();    	
    }
	/** Method: To place a boat on the grid. Only for boat grids
     * 
     * @param boat
     */
    public void placeBoat(Boat boat)
    {
    	if (boat.horizontal == true)
    	{
    		for (int columneNumber= 0; columneNumber<boat.size;columneNumber++)
    			this.casesTable[boat.coordinates.getAxisX()][columneNumber+boat.coordinates.getAxisY()].changeState();
    	}
    	else 
    	{
    		for (int rowNumber= 0; rowNumber<boat.size;rowNumber++)
    			this.casesTable[rowNumber+boat.coordinates.getAxisX()][boat.coordinates.getAxisY()].changeState();
    	}
    }
    
    /**Method : to remove a boat from the grid
     * 
     * @param boat
     */
    public void removeBoat(Boat boat)
    {
    if (boat.horizontal == true)
    	{
    		for (int columnNumber= 0; columnNumber<boat.size;columnNumber++)
    			this.casesTable[boat.coordinates.getAxisX()][columnNumber+boat.coordinates.getAxisY()].changeState();
    	}
    	else 
    	{
    		for (int rowNumber= 0; rowNumber<boat.size;rowNumber++)
    			this.casesTable[rowNumber+boat.coordinates.getAxisX()][boat.coordinates.getAxisY()].changeState();
    	}
    }
    
    /** Method: to move a boat on the grid
     * 
     * @param boat
     * @param coordinates
     * @return boolean: true if the move have been done properly
     */
    public boolean moveBoat(Boat boat, Coordinates coordinates)
    {
    	if (this.movePossible(boat, coordinates))
    	{
    		this.removeBoat(boat);
    		boat.setCoordinates(coordinates);
    		placeBoat(boat);
    		return true;
    	}
    	return false;
    }
    
    /** Method: To get the fleet table of the player
     * 
     * @return his fleet table
     */
  	public Boat[] getFleet() 
  	{
  		return fleet;
  	}
  	
  	/** Method: To rotate a boat
  	 * 
  	 * @param boat
  	 */
  	public void rotationBoat(Boat boat)
  	{
  		this.removeBoat(boat);
  		if (boat.horizontal)
  			boat.setHorizontal(false);
  		else
  			boat.setHorizontal(true);
  		this.placeBoat(boat);
  	}
  	
  	/** Method: To know if we can place a boat on a given position
  	 * 
  	 * @param boat
  	 * @param coordinates
  	 * @return boolean: true if we can move the boat
  	 */
  	public boolean movePossible(Boat boat, Coordinates coordinates)
  	{
  		this.removeBoat(boat);
  		//coordinate on the X and Y axis
  			if (this.isInTheGrid(coordinates))
  			{
  				//for horizontal orientation
  				if(boat.isHorizontal())
  				{
  					if(this.isInTheGrid(new Coordinates(coordinates.getAxisX(),coordinates.getAxisY()+boat.size-1)))
  					{
  						int columnNumber= 0;
  						while (columnNumber<boat.size && this.isCaseAvailable(new Coordinates(coordinates.getAxisX(),coordinates.getAxisY()+columnNumber)))
  							{
  								columnNumber++;
  							}
  						if (columnNumber == boat.size)
  						{
  	  						this.placeBoat(boat);
  	  						return true;
  	  					}
  					}
  				}
  				//for the vertical orientation
  				else
  				{
  					if(this.isInTheGrid(new Coordinates(coordinates.getAxisX()+boat.size-1,coordinates.getAxisY())))
  					{
  						int rowNumber= 0;
  						while (rowNumber<boat.size && this.isCaseAvailable(new Coordinates(coordinates.getAxisX()+rowNumber,coordinates.getAxisY())))
  							rowNumber++;
  						if (rowNumber == boat.size)
  						{
  							this.placeBoat(boat);
  							return true;
  						}
  					}
  				}	
  			}
  			this.placeBoat(boat);
  			return false;
  	}
  	
  	/** Method: To check if the coordinates are in the grid
  	 * 
  	 * @param coordinates
  	 * @return boolean: is in grid or not
  	 */
  	public boolean isInTheGrid(Coordinates coordinates)
  	{
  		if (coordinates.getAxisX()<ROW_NUMBER && coordinates.getAxisX()>=0)
  			if (coordinates.getAxisY()<COLUMN_NUMBER && coordinates.getAxisY()>=0)
  				return true;
  		return false;
  	}
  	
  	/** Method: To assess if there isn't any case used around the current coordinates
  	 * 
  	 * @param coordinates
  	 * @return boolean: true for no case used around
  	 */
  	public boolean isCaseAvailable(Coordinates coordinates)
  	{
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX()-1,coordinates.getAxisY()-1)))
  			if(this.casesTable[coordinates.getAxisX()-1][coordinates.getAxisY()-1].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX()-1,coordinates.getAxisY())))
  			if(this.casesTable[coordinates.getAxisX()-1][coordinates.getAxisY()].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX()-1,coordinates.getAxisY()+1)))
  			if(this.casesTable[coordinates.getAxisX()-1][coordinates.getAxisY()+1].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX(),coordinates.getAxisY()-1)))
  			if(this.casesTable[coordinates.getAxisX()][coordinates.getAxisY()-1].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX(),coordinates.getAxisY()+1)))
  			if(this.casesTable[coordinates.getAxisX()][coordinates.getAxisY()+1].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX()+1,coordinates.getAxisY()-1)))
  			if(this.casesTable[coordinates.getAxisX()+1][coordinates.getAxisY()-1].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX()+1,coordinates.getAxisY())))
  			if(this.casesTable[coordinates.getAxisX()+1][coordinates.getAxisY()].isUsedBool())
  				return false;
  		if (this.isInTheGrid(new Coordinates(coordinates.getAxisX()+1,coordinates.getAxisY()+1)))
  			if(this.casesTable[coordinates.getAxisX()+1][coordinates.getAxisY()+1].isUsedBool())
  				return false;
  		return true;
  	}
  	
}
