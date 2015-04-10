/* TODO package. */
/* TODO JAVADOC. */
public class Case {
    /* TODO JAVADOC. */
    private Coordonnees coordonnes;
    /* TODO JAVADOC. */
    private TypeCase typeCase;
    
    private boolean BoatBool;
    
    private boolean CheckerBool;
    
    public Case (Coordonnees coor,TypeCase type)
    {
    	this.coordonnes = coor;
    	this.typeCase = type;
    	this.BoatBool = false;
    	this.CheckerBool = false;
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
		return BoatBool;
	}
	
	public boolean isCheckerBool() 
	{
		return CheckerBool;
	}
    
}
