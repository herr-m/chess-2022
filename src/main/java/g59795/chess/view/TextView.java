package g59795.chess.view;

import g59795.chess.model.Color;
import g59795.chess.model.Model;
import g59795.chess.model.pieces.*;
import g59795.chess.model.Position;
import java.util.Scanner;

/**
 * Vue du jeu; fournit des outils d'affichage en forme de texte
 * et d'interaction avec le joueur.
 */
public class TextView implements View {
    private final Scanner scanner = new Scanner(System.in);
    private final Model model;
    private String getStringForPiece(Piece piece) {
        if(piece == null) { return "  |"; }
        String str = new String();
        
        if(piece instanceof Pawn) str = "P";
        else if(piece instanceof Bishop) str = "F";
        else if(piece instanceof Knight) str = "C";
        else if(piece instanceof Rook) str = "T";
        else if(piece instanceof Queen) str = "#";
        else if(piece instanceof King) str = "*";
        else if(piece instanceof Joker) str = "J";
        
        return piece.getColor() == Color.WHITE ? str+"B|" : str+"N|";
    }
    
    public TextView(Model model) { this.model = model; }
    
    /**
     * Affiche un message de bienvenue.
     */
    @Override
    public void displayTitle() {
        System.out.println("Bienvenue!");
    }
    
    /**
     * Affiche le plateau du jeu.
     */
    @Override
    public void displayBoard() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        for(int i=7; i>=0; --i) {
            System.out.println("  ------------------------");
            System.out.printf("%d |", i+1);
            for(int j=0; j<8; ++j) {
                System.out.print(getStringForPiece(model.getPiece(new Position(i, j))));
            }
            System.out.println();
        }
        System.out.println("  -------------------------");
        System.out.println("   a  b  c  d  e  f  g  h");
    }

    /**
     * Affiche le gagnant de la partie.
     */
    @Override
    public void displayWinner() {
        System.out.printf("Gagnant: %s%n", model.getCurrentPlayer().getColor());
    }
    
    /**
     * Affiche un message invitant le joueur actuel à jouer.
     */
    @Override
    public void displayPlayer() {
        System.out.println("Au joueur " + model.getCurrentPlayer().getColor() + " de jouer");
    }
    
    /**
     * Demande une position sous forme de texte au joueur.
     * @return Une position valide de type Position.
     */
    @Override
    public Position askPosition() {
        String posString;
        int[] position = new int[2];
        boolean posOK;
        do{
            posOK = true;
            System.out.print(" > ");
            posString = scanner.next().toLowerCase();
            
            if(posString.length() != 2) {
                posOK = false;
                displayError("Position invalide!");
            }
            else {
                position[0] = posString.charAt(0)-97; // char alphabetique -> int
                position[1] = posString.charAt(1)-'0'-1; // char numerique -> int

                if(position[0] < 0 || position[0] > 7 || position[1] < 0 || position[1] > 7) {
                    posOK = false;
                    displayError("Position invalide!");
                }
            }
        } while(!posOK);
        
        return new Position(position[1], position[0]);
    }
    
    /**
     * Affiche un message d'erreur.
     * @param message : Le message à afficher.
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }
    
    /**
     * Affiche un message pour l'echec.
     */
    @Override
    public void displayCheck() {
        System.out.println("Echec");
    }
    
    /**
     * Affiche un message pour l'echec et mat.
     */
    @Override
    public void displayMate() {
        System.out.println("Echec et mat");
    }
    
    /**
     * Affiche un message pour le pat.
     */
    @Override
    public void displayStalemate() {
        System.out.println("Pat");
    }
    
}
