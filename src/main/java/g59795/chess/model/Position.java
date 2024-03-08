package g59795.chess.model;

/**
 * Une position sur le plateau d'échecs.
 */
public class Position {
    private final int row, column;
    
    /**
     * Construit une Position avec les valeurs row et column.
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row; this.column = column;
    }

    /**
     * Retourne la ligne de la position.
     * @return row : ligne de la position
     */
    public int getRow() { return row; }

    /**
     * Retourne la colonne de la position.
     * @return column : colonne de la position
     */
    public int getColumn() { return column; }
    
    /**
     * Retourne une nouvelle position obtenue en se déplaçant 
     * dans la direction dir.
     * 
     * @param dir : la direction à appliquer
     * @return La position après le déplacement
     */
    public Position next(Direction dir) {
        return new Position(row + dir.getDeltaRow(), column + dir.getDeltaColumn());
    }
    
    /**
     * Compare la position à l'objet en paramètre.
     *
     * @param o : L'objet à comparer
     * @return true si la position est égale, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Position)) { return false; }
        
        Position c = (Position) o;
        return row == c.row && column == c.column;
    }
}
