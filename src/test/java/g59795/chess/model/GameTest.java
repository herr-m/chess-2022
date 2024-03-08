package g59795.chess.model;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
    private Model game;
    
    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        game = new Game();
        game.start();
    }

    @Test
    public void testFreshGame() {
        assertEquals(game.getState(), GameState.PLAY);
    }
    
    @Test
    public void testCheck() {
        Position[][] moves = {
            {new Position(1, 4), new Position(3, 4)},
            {new Position(6, 3), new Position(4, 3)},
            {new Position(0, 5), new Position(4, 1)}
        };
        for(Position[] move : moves) 
            { game.movePiecePosition(move[0], move[1]); }
        assertEquals(game.getState(), GameState.CHECK);
    }
    
    @Test
    public void testStalemate() {
        Position[][] moves = {
            {new Position(1, 4), new Position(2, 4)},
            {new Position(6, 0), new Position(4, 0)},
            {new Position(0, 3), new Position(4, 7)},
            {new Position(7, 0), new Position(5, 0)},
            {new Position(4, 7), new Position(4, 0)},
            {new Position(6, 7), new Position(4, 7)},
            {new Position(1, 7), new Position(3, 7)},
            {new Position(5, 0), new Position(5, 7)},
            {new Position(4, 0), new Position(6, 2)},
            {new Position(6, 5), new Position(5, 5)},
            {new Position(6, 2), new Position(6, 3)},
            {new Position(7, 4), new Position(6, 5)},
            {new Position(6, 3), new Position(6, 1)},
            {new Position(7, 3), new Position(2, 3)},
            {new Position(6, 1), new Position(7, 1)},
            {new Position(2, 3), new Position(6, 7)},
            {new Position(7, 1), new Position(7, 2)},
            {new Position(6, 5), new Position(5, 6)},
            {new Position(7, 2), new Position(5, 4)}
        };
        for(Position[] move : moves) 
            { game.movePiecePosition(move[0], move[1]); }
        assertEquals(game.getState(), GameState.STALE_MATE);
    }
}
