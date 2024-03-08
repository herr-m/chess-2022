package g59795.chess.model;

/**
 * Représentation d'un joueur.
 */
public class Player {
    private final Color color;
    
    /**
     * Contruit un joueur de couleur color.
     * @param color : la couleur du joueur.
     */
    public Player(Color color) { this.color = color; }

    /**
     * Renvoie la couleur du joueur.
     * @return La couleur du joueur.
     */
    public Color getColor() { return color; }
}
