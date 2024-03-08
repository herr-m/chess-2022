package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Direction;
import g59795.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'une pièce.
 */
public abstract class Piece {
    private final Color color;
    
    /**
     * Renvoie toutes les positions valides en ligne droite dans les directions donnees.
     * 
     * @param position : La position de depart de la pièce
     * @param board : Le plateau
     * @param directions : Le tableau de directions
     * @return La liste de positions valides
     */
    protected List<Position> getLineMoves(Position position, Board board, Direction[] directions) {
        List result = new ArrayList<Position>();
        for(Direction dir : directions) {
            Position move = position.next(dir);
            while(board.contains(move) && board.isFree(move)) {
                result.add(move);
                move = move.next(dir);
            }
            if(board.contains(move) && board.containsOppositeColor(move, color)) { result.add(move); }
        }
        
        return result;
    }
    
    /**
     * Construit une pièce de couleur color.
     * @param color : couleur de la pièce
     */
    public Piece(Color color)   { this.color = color; }

    /**
     * Renvoie la couleur de la pièce.
     * @return La couleur de la pièce.
     */
    public Color getColor() { return color; }
    
    /**
     * Renvoie tous les deplacements possibles pour cette pièce.
     * @param position : La position de la pièce
     * @param board : Le plateau
     * @return La liste de deplacements possibles
     */
    public abstract List<Position> getPossibleMoves(Position position, Board board);
    
    /**
     * Renvoie les deplacements resultants en une capture pour cette pièce.
     * @param position : La position de la pièce
     * @param board : Le plateau
     * @return La liste de captures possibles
     */
    public List<Position> getCapturePositions(Position position, Board board) {
        return getPossibleMoves(position, board);
    }
}
