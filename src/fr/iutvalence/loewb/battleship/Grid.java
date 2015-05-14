package fr.iutvalence.loewb.battleship;

/** Defines a grid of cases. Designed to contain either boats or checkers */
public abstract class Grid 
{
    /** Constant: row number */
    protected static final int ROW_NUMBER = 10;
	/** Constant: column number */
    protected static final int COLUMN_NUMBER = 10;
    /** Variable: bidimensional cases table*/
    protected Case[][] casesTable;
    
    
    
    /** Method: To create a bidimensional table of cases*/
    public void createGrid() 
    {
        this.casesTable = new Case[ROW_NUMBER][COLUMN_NUMBER];
        for (int rowIndice = 0; rowIndice < ROW_NUMBER; rowIndice++) 
        {
            for (int columnIndice = 0; columnIndice < COLUMN_NUMBER; columnIndice++) 
            {
                this.casesTable[rowIndice][columnIndice] = new Case();
            }
        }
    }
    
    
    
    /** Method: To display on the console a grid with its cases states*/
    public String toString()
    {
    	String asciiGrid = "   | A | B | C | D | E | F | G | H | I | J |\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    	for (int rowNumber = 0; rowNumber<ROW_NUMBER;rowNumber++)
    	{
    		asciiGrid += " "+rowNumber+" ";
    		for (int columnNumber = 0; columnNumber<COLUMN_NUMBER;columnNumber++)
    			asciiGrid += this.casesTable[rowNumber][columnNumber].toString();
    		asciiGrid += "|\n--------------------------------------------\n";
    	}
    	return asciiGrid;
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
}
