package fr.iutvalence.loewb.bataillenavale;
/* TODO package. */
/* TODO JAVADOC. */
public class Coordonnees {
    /* TODO JAVADOC. */
    private int axeX;
    /* TODO JAVADOC. */
    private int axeY;

    /* TODO JAVADOC. */
    /* TODO Franglais. */
    public int getAxeX() {
        return axeX;
    }

    /* TODO JAVADOC. */
    /* TODO Franglais. */
    public int getAxeY() {
        return axeY;
    }
    public Coordonnees(int X, int Y)
    {
    	this.axeX = X;
    	this.axeY = Y;
    }

	public void setAxeX(int axeX) {
		this.axeX = axeX;
	}

	public void setAxeY(int axeY) {
		this.axeY = axeY;
	}
    
}
