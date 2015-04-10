package fr.iutvalence.loewb.bataillenavale;
/* TODO package. */
/* TODO JAVADOC. */
public class Case {
    /* TODO JAVADOC. */
    private final Coordonnees coordonnees;
    /* TODO JAVADOC. */
    private final TypeCase typeCase;
    
    private boolean boatBool;
    
    private boolean checkerBool;
    
    public Case (TypeCase type)
    {
    	this.coordonnees = null;
    	this.typeCase = type;
    	this.boatBool = false;
    	this.checkerBool = false;
    }
    
	public Coordonnees getCoordonnes() 
	{
		return coordonnees;
	}
	
	public TypeCase getTypeCase() 
	{
		return typeCase;
	}
	
	public boolean isBoatBool() 
	{
		return boatBool;
	}
	
	public boolean isCheckerBool() 
	{
		return checkerBool;
	}
	
	public void setCoordonnees(int x, int y)
	{
		this.coordonnees.setAxeX(x);
		this.coordonnees.setAxeY(y);
	}
	}
    
}
