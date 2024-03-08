package g59795.chess.model;

import g59795.chess.model.pieces.Piece;

/**
 * Représentation d'une des 64 cases d'un plateau d'échecs.
 */
public class Square {
    private Piece piece;
    
    /**
     * Construit une case et y place la pièce donnée en paramètre.
     * @param piece : la pièce à placer dans la case.
     */
    public Square(Piece piece) { this.piece = piece; }

    /**
     * Renvoie la pièce présente dans la case.
     * @return La pièce présente dans la case.
     */
    public Piece getPiece() { return piece; }

    /**
     * Place la pièce donnée en paramètre dans la case.
     * @param piece : Pièce à placer dans la case.
     */
    public void setPiece(Piece piece) { this.piece = piece; }

    /**
     * Vérifie si la case est vide.
     * @return True si la case est vide, False sinon.
     */
    public boolean isFree() { return piece == null; }
}
