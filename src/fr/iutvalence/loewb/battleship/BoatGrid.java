package fr.iutvalence.loewb.battleship;

import fr.iutvalence.loewb.boats.AircraftCarrier;
import fr.iutvalence.loewb.boats.Battleship;
import fr.iutvalence.loewb.boats.Destroyer;
import fr.iutvalence.loewb.boats.PetroleBoat;
import fr.iutvalence.loewb.boats.Submarine;

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
    
    public void removeBoat(Boat boat)
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
    public void moveBoat(Boat boat, boolean horizontal, Coordinates coordinates)
    {
    	this.removeBoat(boat);
    	boat.setCoordinates(coordinates);
    	boat.setHorizontal(horizontal);
    	placeBoat(boat);
    }
    /** Method: To get the fleet table of the player
     * 
     * @return his fleet table
     */
  	public Boat[] getFleet() {
  		return fleet;
  	}
}
