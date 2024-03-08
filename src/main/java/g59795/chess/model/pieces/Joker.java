package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d'une pièce Joker
 */
public class Joker extends Piece {

    /**
     * Construit une pièce Joker.
     * @param color : La couleur de la pièce
     */
    public Joker(Color color) { super(color); }

    /**
     * Renvoie les déplacements possibles d'un Joker
     * @param position : La position de départ du Joker
     * @param board : Le plateau du jeu
     * @return Une liste de déplacements possibles
     */
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List result = new ArrayList<Position>();
        Position[] potentialMoves = getColor() == Color.WHITE ? 
                new Position[]{new Position(0, 0), new Position(3, 3), new Position(7, 7)}:
                new Position[]{new Position(0, 7), new Position(4, 3), new Position(7, 0)};
        
            for(Position move : potentialMoves) {
                if(board.isFree(move) || board.getPiece(move) instanceof Queen) { result.add(move);}
            }
        return result;
    }
}
