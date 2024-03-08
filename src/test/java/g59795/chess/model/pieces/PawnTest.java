package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    
    Board board;
    
    public PawnTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesStartingW() {
        Position position = new Position(1,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(3, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWithCaptureW() {
        Position position = new Position(4,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.BLACK), new Position(5, 2));
        
        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(5, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWith2CapturesW() {
        Position position = new Position(4,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.BLACK), new Position(5, 2));
        board.setPiece(new Pawn(Color.BLACK), new Position(5, 0));
        
        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(5, 2),
                new Position(5, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesBoardEdgeW() {
        Position position = new Position(7,1);
        Piece piece = new Pawn(Color.WHITE);
        board.setPiece(piece, position);
        
        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesStartingB() {
        Position position = new Position(6,1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(5, 1),
                new Position(4, 1)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWithCaptureB() {
        Position position = new Position(3,1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.WHITE), new Position(2, 2));
        
        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(2, 2)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWith2CapturesB() {
        Position position = new Position(3,1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.WHITE), new Position(2, 2));
        board.setPiece(new Pawn(Color.WHITE), new Position(2, 0));
        
        List<Position> expected = List.of(
                new Position(2, 1),
                new Position(2, 2),
                new Position(2, 0)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesBoardEdgeB() {
        Position position = new Position(0,1);
        Piece piece = new Pawn(Color.BLACK);
        board.setPiece(piece, position);
        
        List<Position> expected = List.of();

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    /*
     *      Permet de tester si deux listes de positions sont identiques à l'ordre
     *      des éléments prêts. Cette méthode est appelée
     *      par les méthodes de test.
     */
    private void assertEqualsIgnoringOrder(List<Position> expected, List<Position> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));
    }
    
}
