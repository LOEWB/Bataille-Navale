package fr.iutvalence.loewb.model.battleship;


/** Defines the grid extending the class Grid, which is designed to contain checkers */
public class CheckerGrid extends Grid
{
	//TODO
	/** Constructor: The Grid depending on its type 
	 * 
	 * @param type
	 */
	public CheckerGrid()
	{
		createGrid();
	}
	/** Method: This method circle a boat with used cased. This method is used when a boat is dead.
	 * 
	 * @param boat
	 */
	public void circleBoat(Boat boat)
	{
		if (boat.horizontal == true)
		{
			for (int columnNumber= 0; columnNumber<boat.size;columnNumber++)
			{
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()-1,boat.coordinates.getAxisY()-1+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()-1][(boat.coordinates.getAxisY()-1)+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()-1][(boat.coordinates.getAxisY()-1)+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()-1,boat.coordinates.getAxisY()+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()-1][(boat.coordinates.getAxisY())+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()-1][(boat.coordinates.getAxisY())+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()-1,boat.coordinates.getAxisY()+1+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()-1][(boat.coordinates.getAxisY()+1)+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()-1][(boat.coordinates.getAxisY()+1)+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX(),boat.coordinates.getAxisY()-1+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()][(boat.coordinates.getAxisY()-1)+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()][(boat.coordinates.getAxisY()-1)+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX(),boat.coordinates.getAxisY()+1+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()][(boat.coordinates.getAxisY())+1+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()][(boat.coordinates.getAxisY())+1+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()+1,boat.coordinates.getAxisY()-1+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()+1][(boat.coordinates.getAxisY()-1)+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+1][(boat.coordinates.getAxisY()-1)+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()+1,boat.coordinates.getAxisY()+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()+1][(boat.coordinates.getAxisY())+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+1][(boat.coordinates.getAxisY())+columnNumber].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()+1,boat.coordinates.getAxisY()+1+columnNumber)))
					if(!this.casesTable[boat.coordinates.getAxisX()+1][(boat.coordinates.getAxisY()+1)+columnNumber].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+1][(boat.coordinates.getAxisY()+1)+columnNumber].changeState();
			}
		}
		else 
		{
			for (int rowNumber= 0; rowNumber<boat.size;rowNumber++)
			{
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()-1+rowNumber,boat.coordinates.getAxisY()-1)))
					if(!this.casesTable[boat.coordinates.getAxisX()-1+rowNumber][boat.coordinates.getAxisY()-1].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()-1+rowNumber][boat.coordinates.getAxisY()-1].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()-1,boat.coordinates.getAxisY())))
					if(!this.casesTable[boat.coordinates.getAxisX()-1+rowNumber][boat.coordinates.getAxisY()].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()-1+rowNumber][boat.coordinates.getAxisY()].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()-1,boat.coordinates.getAxisY()+1)))
					if(!this.casesTable[boat.coordinates.getAxisX()-1+rowNumber][boat.coordinates.getAxisY()+1].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()-1+rowNumber][boat.coordinates.getAxisY()+1].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX(),boat.coordinates.getAxisY()-1)))
					if(!this.casesTable[boat.coordinates.getAxisX()+rowNumber][boat.coordinates.getAxisY()-1].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+rowNumber][boat.coordinates.getAxisY()-1].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX(),boat.coordinates.getAxisY()+1)))
					if(!this.casesTable[boat.coordinates.getAxisX()+rowNumber][boat.coordinates.getAxisY()+1].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+rowNumber][boat.coordinates.getAxisY()+1].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()+1,boat.coordinates.getAxisY()-1)))
					if(!this.casesTable[boat.coordinates.getAxisX()+1+rowNumber][boat.coordinates.getAxisY()-1].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+1+rowNumber][boat.coordinates.getAxisY()-1].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()+1,boat.coordinates.getAxisY())))
					if(!this.casesTable[boat.coordinates.getAxisX()+1+rowNumber][boat.coordinates.getAxisY()].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+1+rowNumber][boat.coordinates.getAxisY()].changeState();
				if (this.isInTheGrid(new Coordinates(boat.coordinates.getAxisX()+1,boat.coordinates.getAxisY()+1)))
					if(!this.casesTable[boat.coordinates.getAxisX()+1+rowNumber][boat.coordinates.getAxisY()+1].isUsedBool())
						this.casesTable[boat.coordinates.getAxisX()+1+rowNumber][boat.coordinates.getAxisY()+1].changeState();


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
		asciiGrid += "\n\n\tX - Raté/Pas de bateau ici\n\n\tO - Touché\n\n";
		return asciiGrid;
	}

}

