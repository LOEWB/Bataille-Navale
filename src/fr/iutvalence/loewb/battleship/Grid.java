package fr.iutvalence.loewb.battleship;

/* TODO JAVADOC. */
public class Grid {
    /* TODO JAVADOC. */
    private static final int ROW_NUMBER    = 10;
    /* TODO JAVADOC. */
    private static final int COLUMN_NUMBER = 10;
    /* TODO JAVADOC. */
    private TypeGrid typeGrid;
    /* TODO Why retain the player? */
    /* TODO JAVADOC. */
    private Player   player;
    /* TODO JAVADOC. */
    private Case[][] cases;

    public Grid() {
        this.cases = new Case[ROW_NUMBER][COLUMN_NUMBER];
        for (int rowIndice = 0; rowIndice < ROW_NUMBER; rowIndice++) {
            for (int columnIndice = 0; columnIndice < COLUMN_NUMBER; columnIndice++) {
                this.cases[rowIndice][columnIndice].setCoordonnees(rowIndice, columnIndice);
            }
        }
    }
}
