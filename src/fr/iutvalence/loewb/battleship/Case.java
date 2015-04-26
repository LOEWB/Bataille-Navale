package fr.iutvalence.loewb.battleship;

/** Defines a case of a grid. Designed to contain either a part of a boat or a checker */
public class Case 
{
    
    /** Variable: boolean which indicates if the case is used or not (either by a part of a boat or a checker) */
    private boolean used = false;

    /** Constructor*/
    public Case() 
    {
        this.used = false;
    }

    /** Method: To know if the case is used or not 
     * 
     * @return used -> the state of the case
     */
    public boolean isUsedBool() 
    {
        return this.used;
    }
    
    /** Method: To use a case by changing its state if it's not used*/
    public void changeState()
    {
    	if (this.isUsedBool()==false)
    			this.used = true;
    	else 
    		this.used = false;
    }
    
    /** Method: To display the state of a case using asciiArt
     * 
     * @return a string displaying the state of the case using asciiArt
     */
    public String toString()
    {
    	if (this.isUsedBool()==false)
    		return "|   ";
    	else return "| X ";
    }
}

