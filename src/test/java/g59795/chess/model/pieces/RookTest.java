package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    
    Board board;
    
    public RookTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesMiddle() {
        Position position = new Position(3,3);
        Piece piece = new Rook(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(14, positions.size());
    }
    
    @Test
    public void testGetPossibleMovesWithCapture() {
        Position position = new Position(3,3);
        Piece piece = new Rook(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.BLACK), new Position(5, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(12, positions.size());
    }
    
    @Test
    public void testGetPossibleMovesAlliesInTheWay() {
        Position position = new Position(3,3);
        Piece piece = new Rook(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.WHITE), new Position(3, 1));
        board.setPiece(new Pawn(Color.WHITE), new Position(3, 5));
        board.setPiece(new Pawn(Color.WHITE), new Position(1, 3));
        board.setPiece(new Pawn(Color.WHITE), new Position(5, 3));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(4, positions.size());
    }
    
    @Test
    public void testGetPossibleMovesEdge() {
        Position position = new Position(0, 0);
        Piece piece = new Rook(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(14, positions.size());
    }
}
