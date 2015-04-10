package fr.iutvalence.loewb.bataillenavale;
/* TODO package. */
/* TODO JAVADOC. */
public class Case {
    /* TODO JAVADOC. */
    private final Coordonnees coordonnes;
    /* TODO JAVADOC. */
    private final TypeCase typeCase;
    
    private boolean boatBool;
    
    private boolean checkerBool;
    
    public Case (Coordonnees coor,TypeCase type)
    {
    	this.coordonnes = coor;
    	this.typeCase = type;
    	this.boatBool = false;
    	this.checkerBool = false;
    }
    
	public Coordonnees getCoordonnes() 
	{
		return coordonnes;
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
    
}
