package fr.iutvalence.loewb.model.battleship;

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
	/** Method: To display on the console a grid with its cases states and the caption
	 * 
	 * @return String: the grid
	 */
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
		asciiGrid += "\n\n\tX - Bateau\n\n";
		return asciiGrid;
	}


}
