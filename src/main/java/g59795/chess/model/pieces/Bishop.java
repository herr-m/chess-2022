package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Direction;
import g59795.chess.model.Position;
import java.util.List;

/**
 * Representation d'un fou.
 */
public class Bishop extends Piece {

    /**
     * Construit un fou de couleur color.
     * @param color : couleur du fou
     */
    public Bishop(Color color) { super(color); }
    
    /**
     * Renvoie une liste de position de déplacements possibles pour un fou.
     * @param position : La position du fou
     * @param board : Le plateau
     * @return La liste de positions de déplacements possibles.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        return super.getLineMoves(position, board, new Direction[]{Direction.NE, Direction.SE, Direction.SW, Direction.NW});
    }
}
