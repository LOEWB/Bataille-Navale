package fr.iutvalence.loewb.bataillenavale;

public class Grid 
{
	private TypeGrid typeGrid;
	private Player player;
	private Case[][] cases;
	
	private final static int ROW_NUMBER = 10;
	private final static int COLUMN_NUMBER = 10;

	private void createGrid()
	{
		this.cases = new Case[ROW_NUMBER][COLUMN_NUMBER];
		for (int rowIndice=0;rowIndice<ROW_NUMBER;rowIndice++)
		{
			for(int columnIndice=0;rowIndice<COLUMN_NUMBER;columnIndice++)
			{
				this.cases[rowIndice][columnIndice].setCoordonnees(rowIndice, columnIndice);
			}
		}
	}
}
