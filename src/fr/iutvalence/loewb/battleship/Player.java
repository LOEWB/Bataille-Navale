package fr.iutvalence.loewb.battleship;

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
        
    }
    
    /** Method: To get the name of the player
     * 
     * @return his name
     */
    public String getName() {
  		return name;
  	}
    /** Method: To get the number of the player
     * 
     * @return his number
     */
  	public int getNumber() {
  		return number;
  	}
  	/** Method: To get the boat grid of the player
     * 
     * @return his boat grid
     */
  	public BoatGrid getBoatGrid() {
  		return boatGrid;
  	}
  	/** Method: To get the checker grid of the player
     * 
     * @return his checker grid
     */
  	public CheckerGrid getCheckerGrid() {
  		return checkerGrid;
  	}
}
