package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Direction;
import g59795.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un pion.
 */
public class Pawn extends Piece {
    private Direction getMovementDirection() {
        return getColor() == Color.WHITE ? Direction.N : Direction.S;
    }
    private Direction[] getCaptureDirections() {
        return getColor() == Color.WHITE ? 
                new Direction[]{Direction.NW, Direction.NE} : 
                new Direction[]{Direction.SW, Direction.SE};
    }
    
    /**
     * Construit un pion de couleur color.
     * @param color : couleur du pion
     */
    public Pawn(Color color) { super(color); }

    /**
     * Renvoie une liste de position de déplacements possibles pour un pion.
     * @param position : La position du pion
     * @param board : Le plateau
     * @return La liste de positions de déplacements possibles.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List result = new ArrayList<Position>();
        Position nextPos = position.next(getMovementDirection());
        
        // Case devant le pion (N pour blanc, S pour noir)
        if(board.contains(nextPos) && board.isFree(nextPos)) 
            { result.add(nextPos); }
        
        // 2 cases devant le pion (N pour blanc, S pour noir)
        if(board.getInitialPawnRow(getColor()) == position.getRow() && board.isFree(nextPos) && board.isFree(nextPos.next(getMovementDirection()))) 
            { result.add(nextPos.next(getMovementDirection())); }
        
        result.addAll(getCapturePositions(position, board));
        return result;
    }
    
    /**
     * Renvoie une liste de position de capture possibles pour un pion.
     * @param position : La position du pion
     * @param board : Le plateau
     * @return La liste de positions de capture possibles.
     */
    @Override
    public List<Position> getCapturePositions(Position position, Board board) {
        List result = new ArrayList<Position>();
        Position nextPos;
        for(Direction dir : getCaptureDirections()) {
            nextPos = position.next(dir);
            if(board.contains(nextPos) && board.containsOppositeColor(nextPos, getColor()))
                result.add(nextPos);
        }
        
        return result;
    }
}
