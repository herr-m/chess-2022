package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Direction;
import g59795.chess.model.Position;
import java.util.List;

/**
 * Representation d'une tour.
 */
public class Rook extends Piece {

    /**
     * Construit une tour de couleur color.
     * @param color : couleur de la tour
     */
    public Rook(Color color) { super(color); }
    
    /**
     * Renvoie une liste de position de déplacements possibles pour une tour.
     * @param position : La position de la tour
     * @param board : Le plateau
     * @return La liste de positions de déplacements possibles.
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        return getLineMoves(position, board, new Direction[]{Direction.N, Direction.E, Direction.S,Direction.W});
    }
}
