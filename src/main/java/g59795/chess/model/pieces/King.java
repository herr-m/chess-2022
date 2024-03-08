package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Direction;
import g59795.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un roi.
 */
public class King extends Piece {

    /**
     * Construit un roi de couleur color.
     * @param color : couleur du roi
     */
    public King(Color color) { super(color); }
    
    /**
     * Renvoie une liste de position de déplacements possibles pour un roi.
     * @param position : La position du roi
     * @param board : Le plateau
     * @return La liste de positions de déplacements possibles.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List result = new ArrayList<Position>();
        for(Direction dir : Direction.values()) {
            Position move = position.next(dir);
            if(board.contains(move) && ( board.isFree(move) || board.containsOppositeColor(move, getColor()) )) 
                { result.add(move); }
        }
        
        return result;
    }
}
