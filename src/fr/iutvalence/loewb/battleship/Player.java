package fr.iutvalence.loewb.battleship;

import fr.iutvalence.loewb.boats.AircraftCarrier;
import fr.iutvalence.loewb.boats.Battleship;
import fr.iutvalence.loewb.boats.Destroyer;
import fr.iutvalence.loewb.boats.PetroleBoat;
import fr.iutvalence.loewb.boats.Submarine;

/** Defines a player */
public class Player 
{
    /** Variable: final string for his name */
    private final String name;
    /** Variable: final integer for his age */
    private final int number;
    /** Variable: final grid of boat. Those boats are placed by this current player*/
	public final BoatGrid boatGrid;
	/** Variable: final grid of checkers. Those checkers are placed by the enemy of this current player*/
    public final CheckerGrid checkerGrid;
    public Player opponent;
    private final Boat aircraftCarrier;
    private final Boat battleship;
    private final Boat destroyer;
    private final Boat petroleBoat;
    private final Boat submarine;
    

    /** Constructor: a player depending on his name and his number
     * 
     * @param name
     * @param number
     */
    public Player(String name, int number) 
    {
        this.name = name;
        this.number = number;
        this.boatGrid = new BoatGrid();
        this.checkerGrid = new CheckerGrid();
        this.aircraftCarrier = new AircraftCarrier();
        this.battleship = new Battleship();
        this.destroyer = new Destroyer();
        this.petroleBoat = new PetroleBoat();
        this.submarine = new Submarine();
    }
    
    public Boat getAircraftCarrier() {
		return aircraftCarrier;
	}

	public Boat getBattleship() {
		return battleship;
	}

	public Boat getDestroyer() {
		return destroyer;
	}

	public Boat getPetroleBoat() {
		return petroleBoat;
	}

	public Boat getSubmarine() {
		return submarine;
	}

	/** Method: To get the name of the player
     * 
     * @return his name
     */
    public String getName() 
    {
  		return name;
  	}
    /** Method: To get the number of the player
     * 
     * @return his number
     */
  	public int getNumber() 
  	{
  		return number;
  	}
  	/** Method: To get the boat grid of the player
     * 
     * @return his boat grid
     */
  	public BoatGrid getBoatGrid() 
  	{
  		return boatGrid;
  	}
  	/** Method: To get the checker grid of the player
     * 
     * @return his checker grid
     */
  	public CheckerGrid getCheckerGrid() 
  	{
  		return checkerGrid;
  	}
  	/** Method: To place a boat on the boat grid
     * 
     * @param boat
     */
    public void placeBoat(Boat boat, Coordinates coordinates)
    {
    	if(!boat.placed)
    	{
    		if(this.movePossible(boat, coordinates))
    		{
    			boat.placed = true;
    			boat.setCoordinates(coordinates);
    			if (boat.horizontal == true)
    			{
    				for (int columneNumber= 0; columneNumber<boat.size;columneNumber++)
    				{
    					this.boatGrid.casesTable[coordinates.getAxisX()][columneNumber+coordinates.getAxisY()].changeState();
    					this.boatGrid.casesTable[coordinates.getAxisX()][columneNumber+coordinates.getAxisY()].boat = boat;
    				}
    			}
    			else 
    			{
    				for (int rowNumber= 0; rowNumber<boat.size;rowNumber++)
    				{
    					this.boatGrid.casesTable[rowNumber+coordinates.getAxisX()][coordinates.getAxisY()].changeState();
    					this.boatGrid.casesTable[rowNumber+coordinates.getAxisX()][coordinates.getAxisY()].boat = boat;
    				}
    			}
    		}
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
    	if (boat.placed)
    	{
    		this.removeBoat(boat);
    		if (this.movePossible(boat, coordinates))
    		{
    			boat.setCoordinates(coordinates);
    			placeBoat(boat,coordinates);
    			return true;
    		}
    		placeBoat(boat,boat.getCoordinates());
    		return false;
    	}
    	return false;
    }
	
  	/** Method: To rotate a boat
  	 * 
  	 * @param boat
  	 */
    public void rotationBoat(Boat boat)
    {
    	if (boat.placed)
    	{
    		this.removeBoat(boat);
    		if(this.rotationPossible(boat))
    		{
    			if (boat.horizontal)
    				boat.setHorizontal(false);
    			else
    				boat.setHorizontal(true);
    		}
    		this.placeBoat(boat,boat.getCoordinates());
    	}
    }
    

    /**Method : to remove a boat from the grid
     * 
     * @param boat
     */
    public void removeBoat(Boat boat)
    {
    	if(boat.placed)
    	{
    		boat.placed = false;
    		if (boat.horizontal == true)
    		{
    			for (int columnNumber= 0; columnNumber<boat.size;columnNumber++)
    			{
    				this.boatGrid.casesTable[boat.coordinates.getAxisX()][columnNumber+boat.coordinates.getAxisY()].changeState();
    				this.boatGrid.casesTable[boat.coordinates.getAxisX()][columnNumber+boat.coordinates.getAxisY()].boat = null;
    			}
    		}
    		else 
    		{
    			for (int rowNumber= 0; rowNumber<boat.size;rowNumber++)
    			{
    				this.boatGrid.casesTable[rowNumber+boat.coordinates.getAxisX()][boat.coordinates.getAxisY()].changeState();
    				this.boatGrid.casesTable[rowNumber+boat.coordinates.getAxisX()][boat.coordinates.getAxisY()].boat = null;
    			}
    		}
    	}
    }

  	/** Method: To know if we can place a boat on a given position
  	 * 
  	 * @param boat
  	 * @param coordinates
  	 * @return boolean: true if we can move the boat
  	 */
  	public boolean movePossible(Boat boat, Coordinates coordinates)
  	{
  		//coordinate on the X and Y axis
  			if (this.boatGrid.isInTheGrid(coordinates))
  			{
  				//for horizontal orientation
  				if(boat.isHorizontal())
  				{
  					if(this.boatGrid.isInTheGrid(new Coordinates(coordinates.getAxisX(),coordinates.getAxisY()+boat.size-1)))
  					{
  						int columnNumber= 0;
  						while (columnNumber<boat.size && this.boatGrid.isCaseAvailable(new Coordinates(coordinates.getAxisX(),coordinates.getAxisY()+columnNumber)))
  							{
  								columnNumber++;
  							}
  						if (columnNumber == boat.size)
  						{
  	  						return true;
  	  					}
  					}
  				}
  				//for the vertical orientation
  				else
  				{
  					if(this.boatGrid.isInTheGrid(new Coordinates(coordinates.getAxisX()+boat.size-1,coordinates.getAxisY())))
  					{
  						int rowNumber= 0;
  						while (rowNumber<boat.size && this.boatGrid.isCaseAvailable(new Coordinates(coordinates.getAxisX()+rowNumber,coordinates.getAxisY())))
  							rowNumber++;
  						if (rowNumber == boat.size)
  						{
  							return true;
  						}
  					}
  				}	
  			}
  			return false;
  	}
  	
  	public boolean rotationPossible(Boat boat)
  	{
  		boat.setHorizontal(!boat.isHorizontal());
  		if(this.movePossible(boat, boat.getCoordinates()))
  		{
  			boat.setHorizontal(!boat.isHorizontal());
  			return true;
  		}

  		boat.setHorizontal(!boat.isHorizontal());
  		return false;
  	}
  	
  	public void hit(Coordinates coordinates)
  	{
  		if (this.checkerGrid.isInTheGrid(coordinates))
  		{
  			if (!this.checkerGrid.casesTable[coordinates.getAxisX()][coordinates.getAxisY()].isUsedBool())
  			{
  				if(this.opponent.boatGrid.casesTable[coordinates.getAxisX()][coordinates.getAxisY()].isUsedBool())
  				{
  					this.checkerGrid.casesTable[coordinates.getAxisX()][coordinates.getAxisY()].changeHitState();
  					this.checkerGrid.casesTable[coordinates.getAxisX()][coordinates.getAxisY()].changeState();
  					this.opponent.boatGrid.casesTable[coordinates.getAxisX()][coordinates.getAxisY()].boat.healthPoints--;
  				}
  				else
  					this.checkerGrid.casesTable[coordinates.getAxisX()][coordinates.getAxisY()].changeState();
  			}
  		}
  	}
}
