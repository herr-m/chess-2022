package g59795.chess.model.pieces;

import g59795.chess.model.Board;
import g59795.chess.model.Color;
import g59795.chess.model.Position;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    
    Board board;
    
    public KingTest() {
    }
    
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetPossibleMovesMiddle() {
        Position position = new Position(3,3);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);

        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4),
                new Position(3, 4),
                new Position(3, 2),
                new Position(4, 3),
                new Position(4, 2),
                new Position(4, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesWithCapture() {
        Position position = new Position(3,3);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.BLACK), new Position(2, 2));
        
        List<Position> expected = List.of(
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4),
                new Position(3, 4),
                new Position(3, 2),
                new Position(4, 3),
                new Position(4, 2),
                new Position(4, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesAlliesInTheWay() {
        Position position = new Position(3,3);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        board.setPiece(new Pawn(Color.WHITE), new Position(2, 2));
        board.setPiece(new Pawn(Color.WHITE), new Position(3, 4));
        
        List<Position> expected = List.of(
                new Position(2, 3),
                new Position(2, 4),
                new Position(3, 2),
                new Position(4, 3),
                new Position(4, 2),
                new Position(4, 4)
        );

        List<Position> positions = piece.getPossibleMoves(position, board);

        assertEqualsIgnoringOrder(expected, positions);
    }
    
    @Test
    public void testGetPossibleMovesEdge() {
        Position position = new Position(0, 0);
        Piece piece = new King(Color.WHITE);
        board.setPiece(piece, position);
        
        List<Position> expected = List.of(
                new Position(0, 1),
                new Position(1, 1),
                new Position(1, 0)
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
