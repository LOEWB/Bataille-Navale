package fr.iutvalence.loewb.battleship;

/* TODO JAVADOC. */
public class Case {
    /* TODO Translate. */
    /* TODO JAVADOC. */
    private final Coordonnees coordonnees;
    /* TODO JAVADOC. */
    private final TypeCase    typeCase;
    /* TODO JAVADOC. */
    /* TODO boatBool ≠ typeCase == TypeCase.BOAT ? */
    private boolean boatBool;
    /* TODO JAVADOC. */
	/* TODO boatBool ≠ typeCase == TypeCase.CHECKER ? */
    private boolean checkerBool;

    /* TODO JAVADOC. */
    public Case(TypeCase type) {
        this.coordonnees = null;
        this.typeCase = type;
        this.boatBool = false;
        this.checkerBool = false;
    }

    /* TODO Translate. */
    /* TODO JAVADOC. */
    public Coordonnees getCoordonnes() {
        return coordonnees;
    }

    /* TODO JAVADOC. */
    public TypeCase getTypeCase() {
        return typeCase;
    }

    /* TODO JAVADOC. */
    public boolean isBoatBool() {
        return boatBool;
    }

    /* TODO JAVADOC. */
    public boolean isCheckerBool() {
        return checkerBool;
    }

    /* TODO "Coordonnees" are mutable ? */
    /* TODO JAVADOC. */
    public void setCoordonnees(int x, int y) {
        this.coordonnees.setAxeX(x);
        this.coordonnees.setAxeY(y);
    }
}
}
