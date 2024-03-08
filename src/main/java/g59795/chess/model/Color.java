package g59795.chess.model;

/**
 * L'énumération Color représente la couleur d'une pièce, d'une case ou
 * d'un joueur; Elle peut etre blanche (WHITE) ou noire (BLACK).
 */
public enum Color {
    WHITE,
    BLACK;
    
    /**
     * Renvoie la couleur opposée.
     * @return BLACK si blanc, sinon WHITE
     */
    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
    
    /**
     * Renvoie la couleur sous forme de texte.
     * @return La couleur sous forme de texte.
     */
    @Override
    public String toString() {
        return this == WHITE ? "Blanc" : "Noir";
    }
}
