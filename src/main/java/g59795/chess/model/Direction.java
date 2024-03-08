package g59795.chess.model;

/**
 * Representation d'une direction à l'aide d'un des 4 points cardinaux ou d'un 
 * point intermédiaire.
 */
public enum Direction {
    NW(1, -1),
    N(1, 0),
    NE(1, 1),
    W(0, -1),
    E(0, 1),
    SW(-1, -1),
    S(-1, 0),
    SE(-1, 1);
    
    private final int deltaRow, deltaColumn;
    private Direction(int deltaR, int deltaC) {
        deltaRow = deltaR; deltaColumn = deltaC;
    }
    
    /**
     *  Retourne le déplacement vertical.
     * @return deltaRow : déplacement vertical
     */
    public int getDeltaRow() { return deltaRow; }

    /**
     * Retourne le déplacement horizontal.
     * @return deltaCol : déplacement horizontal
     */
    public int getDeltaColumn() { return deltaColumn; }
}
