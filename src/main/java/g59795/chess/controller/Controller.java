package g59795.chess.controller;

import g59795.chess.model.GameState;
import g59795.chess.model.Model;
import g59795.chess.model.Position;
import g59795.chess.view.View;

/**
 * Controlleur de la partie.
 */
public class Controller {
    private final Model model;
    private final  View view;
    
    /**
     * Construit le contrôleur avec le modèle et la vue fournie.
     * @param model : Le modele
     * @param view : La vue
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
    /**
     * Lance une partie et demande aux joueurs de jouer en alternance.
     */
    public void play() {
        view.displayTitle();
        model.start();
        GameState state = model.getState();
        while(state == GameState.PLAY || state == GameState.CHECK){
            view.displayBoard();
            if(state == GameState.CHECK) { view.displayCheck(); }
            view.displayPlayer();
            
            boolean posOK;
            Position p1;
            Position p2;
            
            view.displayError("Choisisez une piece");
            do{
                posOK = true;
                p1 = view.askPosition();
                if(!model.isCurrentPlayerPosition(p1)) {
                    posOK = false;
                    view.displayError("Piece invalide!");
                }
                else if(model.getPossibleMoves(p1).isEmpty()) {
                    posOK = false;
                    view.displayError("Cette piece n'a pas de deplacements possibles!");
                }
            } while(!posOK);
            
            view.displayError("Deplacez votre piece (ou choisissez en une autre)");
            do{
                posOK = true;
                
                p2 = view.askPosition();
                
                // Choix d'une autre piece
                if(!p1.equals(p2) && model.isCurrentPlayerPosition(p2)) {
                    posOK = false;
                    if(model.getPossibleMoves(p1).isEmpty()) {
                        view.displayError("Cette piece n'a pas de deplacements possibles!");
                    }
                    else { 
                        p1 = p2; 
                    }
                }
                
                // Deplacement
                else if(!(model.getPossibleMoves(p1).contains(p2) && model.isMoveValid(p1, p2))) {
                    
                    posOK = false;
                    view.displayError("Deplacement invalide!");
                }
            } while(!posOK);
            model.movePiecePosition(p1, p2);
            state = model.getState();
        }
        
        // End screen
        view.displayBoard();
        switch (state) {
            case CHECK_MATE:
                view.displayMate();
                view.displayWinner();
                break;
            case STALE_MATE:
                view.displayStalemate();
                break;
            default:
                break;
        }
    }
}
