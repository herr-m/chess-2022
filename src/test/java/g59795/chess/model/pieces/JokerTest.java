package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JokerTest {
    
    Board board;
    
    public JokerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesMiddle() {
        Position position = new Position(3,3);
        Piece piece = new Joker(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(2, positions.size());
    }
    
    @Test
    public void testGetPossibleMovesCaptureQueen() {
        Position position = new Position(3,3);
        Piece piece = new Joker(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Queen(Color.BLACK), new Position(0, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(2, positions.size());
    }
    
    @Test
    public void testGetPossibleMovesCapturePawn() {
        Position position = new Position(3,3);
        Piece piece = new Joker(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.BLACK), new Position(0, 0));

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEquals(1, positions.size());
    }
}
