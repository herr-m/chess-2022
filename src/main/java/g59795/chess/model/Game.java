package g59795.chess.model;

import g59795.chess.model.pieces.*;
import g59795.chess.model.pieces.Pawn;
import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d'une partie de jeu d'échecs.
 */
public class Game implements Model {
    private final Board board;
    private final Player white, black;
    private GameState state;
    private King whiteKing, blackKing;
    private Player currentPlayer;
    
    private List<Position> getCapturePositions(Player player) {
        List result = new ArrayList<Position>();
        for(Position pos : board.getPositionsOccupiedBy(player)) {
            result.addAll(board.getPiece(pos).getCapturePositions(pos, board));
        }
        
        return result;
    }
    
    private boolean hasValidMoves(Player player) {
        for(Position oldPos : board.getPositionsOccupiedBy(player)) {
            for(Position newPos : board.getPiece(oldPos).getPossibleMoves(oldPos, board)) {
                if(isMoveValid(oldPos, newPos)) { return true; }
            }
        }
        
        return false;
    }
    
    /**
     * Construit le plateau et les joueurs.
     */
    public Game() {
        board = new Board();
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
    }

    /**
     * Initie une partie de jeu: créé les pièces et les place sur le plateau.
     */
    @Override
    public void start() {
        state = GameState.PLAY;
        currentPlayer = white;
        whiteKing = new King(Color.WHITE);
        blackKing = new King(Color.BLACK);
        
        //Set the white pieces
        board.setPiece(whiteKing, new Position(0, 4));
        board.setPiece(new Queen(Color.WHITE), new Position(0, 3));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 2));
        board.setPiece(new Bishop(Color.WHITE), new Position(0, 5));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 1));
        board.setPiece(new Knight(Color.WHITE), new Position(0, 6));
        board.setPiece(new Rook(Color.WHITE), new Position(0, 7));
        board.setPiece(new Rook(Color.WHITE), new Position(0, 0));
        board.setPiece(new Joker(Color.WHITE), new Position(3, 3));
        
        //Set the white pieces
        board.setPiece(blackKing, new Position(7, 4));
        board.setPiece(new Queen(Color.BLACK), new Position(7, 3));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 2));
        board.setPiece(new Bishop(Color.BLACK), new Position(7, 5));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 1));
        board.setPiece(new Knight(Color.BLACK), new Position(7, 6));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 7));
        board.setPiece(new Rook(Color.BLACK), new Position(7, 0));
        board.setPiece(new Joker(Color.BLACK), new Position(4, 3));
        
        // Set the pawns
        for(int i=0; i<8; ++i) {
            board.setPiece(new Pawn(Color.WHITE), new Position(board.getInitialPawnRow(Color.WHITE), i));
            board.setPiece(new Pawn(Color.BLACK), new Position(board.getInitialPawnRow(Color.BLACK), i));
        }
    }

    /**
     * Renvoie la pièce sur la position donnée.
     * @param pos : La position
     * @return La pièce sur la position pos
     * @throws IllegalArgumentException pos n'existe pas sur le plateau.
     */
    @Override
    public Piece getPiece(Position pos) { return board.getPiece(pos); }

    /**
     * Renvoie le joueur actuel.
     * @return Le joueur actuel
     */
    @Override
    public Player getCurrentPlayer() { return currentPlayer; }

    /**
     * Renvoie l'autre joueur.
     * @return L'autre joueur
     */
    @Override
    public Player getOppositePlayer() {
        return currentPlayer == white ? black : white;
    }

    /**
     * Vérifie si la case est occupée par une pièce du joueur actuel.
     * @param pos : La position de la case
     * @return true si la case est occupée par une pièce du joueur actuel, 
     * sinon false.
     * @throws IllegalArgumentException pos n'existe pas sur le plateau.
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        return board.containsOppositeColor(pos, currentPlayer.getColor().opposite());
    }

    /**
     * Déplace une pièce sur le plateau et change de joueur si 
     * la partie n'est pas terminée.
     * @param oldPos La position de la pièce
     * @param newPos La position ou la pièce sera placée
     * @throws IllegalArgumentException si
     *                                  1) oldPos ou newPos n'existe pas sur le plateau, ou
     *                                  2) oldPos contient aucune pièce, ou
     *                                  3) la pièce n'appartient pas au joueur actuel, ou
     *                                  4) le déplacement n'est pas valide pour cette pièce
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if(board.isFree(oldPos)) 
            throw new IllegalArgumentException("La case oldPos est vide!");
        else if(board.getPiece(oldPos).getColor() != currentPlayer.getColor()) 
            throw new IllegalArgumentException("Cette pièce appartient au joueur adverse!");
        else if(!(getPossibleMoves(oldPos).contains(newPos) && isMoveValid(oldPos, newPos))) 
            throw new IllegalArgumentException("Cette pièce ne peut se déplacer de cette façon!");
        
        board.setPiece(board.getPiece(oldPos), newPos);
        board.dropPiece(oldPos);
        
        King opponentsKing = currentPlayer == white ? blackKing : whiteKing;
        if(getCapturePositions(currentPlayer).contains(board.getPiecePosition(opponentsKing)))
            state = GameState.CHECK;
        else state = GameState.PLAY;
        
        if(!hasValidMoves(getOppositePlayer())) {
            if(state == GameState.CHECK) state = GameState.CHECK_MATE;
            else state = GameState.STALE_MATE;
        }
        else { currentPlayer = getOppositePlayer(); }
    }

    /**
     * Renvoie une liste de déplacements possibles pour la pièce 
     * à la position donnée.
     * @param position : La position
     * @return La liste de déplacements possibles
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }
    
    /**
     * Vérifie si le déplacement donné est valide.
     *
     * @param oldPos : L'ancienne position du déplacemnt
     * @param newPos : Nouvelle position du déplacement
     * @return true si le déplacement est valide, sinon false
     * @throws IllegalArgumentException si le déplacement n'est pas possible.
     */
    @Override
    public boolean isMoveValid(Position oldPos, Position newPos) {
        if(board.isFree(oldPos) || !board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) 
            throw new IllegalArgumentException();
        
        King currentPlayersKing = board.getPiece(oldPos).getColor() == Color.WHITE ? whiteKing : blackKing;
        Player opponent = board.getPiece(oldPos).getColor() == Color.WHITE ? black : white;
        // Save the pieces
        Piece oldPosPiece = board.getPiece(oldPos);
        Piece newPosPiece = board.getPiece(newPos);
        
        // Simulate the move
        board.setPiece(oldPosPiece, newPos);
        board.dropPiece(oldPos);
        
        boolean result = !getCapturePositions(opponent).contains(board.getPiecePosition(currentPlayersKing));
        
        // Restore the pieces
        board.setPiece(oldPosPiece, oldPos);
        board.setPiece(newPosPiece, newPos);
        
        return result;
    }
    
    /**
     * Accesseur de etat du jeu.
     * 
     * @return l'etat du jeu
     */
    @Override
    public GameState getState() { return state; }
}