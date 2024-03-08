package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un cavalier.
 */
public class Knight extends Piece {

    /**
     * Construit un cavalier de couleur color.
     * @param color : couleur du cavalier
     */
    public Knight(Color color) { super(color); }

    /**
     * Renvoie une liste de position de déplacements possibles pour un cavalier.
     * @param position : La position du cavalier
     * @param board : Le plateau
     * @return La liste de positions de déplacements possibles.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        Position[] potentialMoves = {
        new Position(position.getRow() + 1, position.getColumn() + 2),
        new Position(position.getRow() - 1, position.getColumn() + 2),
        new Position(position.getRow() + 1, position.getColumn() - 2),
        new Position(position.getRow() - 1, position.getColumn() - 2),
        new Position(position.getRow() + 2, position.getColumn() + 1),
        new Position(position.getRow() - 2, position.getColumn() + 1),
        new Position(position.getRow() + 2, position.getColumn() - 1),
        new Position(position.getRow() - 2, position.getColumn() - 1)
        };
        
        List result = new ArrayList<Position>();
        for(Position move : potentialMoves) {
            if(board.contains(move) && ( board.isFree(move) || board.containsOppositeColor(move, getColor()) )) 
                { result.add(move); }
        }
        
        return result;
    }
}
