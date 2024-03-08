package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    Board board;
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesMiddle() {
        Position position = new Position(3,3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(1, 2),
                new Position(2, 1),
                new Position(4, 1),
                new Position(5, 2),
                new Position(5, 4),
                new Position(4, 5),
                new Position(2, 5),
                new Position(1, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWithCapture() {
        Position position = new Position(3,3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.BLACK), new Position(2, 5));
        
        List<Position> expected = List.of(
                new Position(1, 2),
                new Position(2, 1),
                new Position(4, 1),
                new Position(5, 2),
                new Position(5, 4),
                new Position(4, 5),
                new Position(2, 5),
                new Position(1, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesAlliesInTheWay() {
        Position position = new Position(3,3);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.WHITE), new Position(2, 5));
        board.setPiece(new Pawn(Color.WHITE), new Position(5, 4));
        
        List<Position> expected = List.of(
                new Position(1, 2),
                new Position(2, 1),
                new Position(4, 1),
                new Position(5, 2),
                new Position(4, 5),
                new Position(1, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesEdge() {
        Position position = new Position(0, 0);
        Piece piece = new Knight(Color.WHITE);
        board.setPiece(piece, position);
        
        List<Position> expected = List.of(
                new Position(1, 2),
                new Position(2, 1)
        );

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
