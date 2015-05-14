package fr.iutvalence.loewb.battleship;

/** Defines the grid extending the class Grid, which is designed to contain boats */
public class BoatGrid extends Grid
{    
    
    /** Constructor: The Grid depending on its type 
     * 
     * @param type
     */
    public BoatGrid()
    {
    	createGrid();
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
