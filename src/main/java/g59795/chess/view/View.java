package g59795.chess.view;

import g59795.chess.model.Position;

/**
 * Vue du jeu; fournit des outils d'affichage et d'interaction avec le joueur.
 */
public interface View {
    /**
     * Affiche un message de bienvenue.
     */
    public void displayTitle();

    /**
     * Affiche le plateau du jeu.
     */
    public void displayBoard();

    /**
     * Affiche le gagnant de la partie.
     */
    public void displayWinner();

    /**
     * Affiche un message invitant le joueur actuel à jouer.
     */
    public void displayPlayer();

    /**
     * Demande une position sous forme de texte au joueur.
     * @return Une position valide de type Position.
     */
    public Position askPosition();

    /**
     * Affiche un message d'erreur.
     * @param message : Le message à afficher.
     */
    public void displayError(String message);
    
    /**
     * Affiche un message pour l'echec.
     */
    public void displayCheck();

    /**
     * Affiche un message pour l'echec et mat.
     */
    public void displayMate();

    /**
     * Affiche un message pour le pat.
     */
    public void displayStalemate();
}
