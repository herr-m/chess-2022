package g59795.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe Position.
 */
public class PositionTest {
    @Test
    public void testGetters() {
        Position instance = new Position(4, 4);
        int expResultRow = 4; int expResultColumn = 4;
        
        assertEquals(expResultRow, instance.getRow());
        assertEquals(expResultColumn, instance.getColumn());
    }
    
    @Test
    public void testNext() {
        Direction dir = Direction.NW;
        Position instance = new Position(4, 4);
        int expResultRow = 5; int expResultColumn = 3;
        Position result = instance.next(dir);
        
        assertEquals(expResultRow, result.getRow());
        assertEquals(expResultColumn, result.getColumn());
    }
    
    @Test
    public void testEquals() {
        Position pos1 = new Position(4, 4);
        Position pos2 = new Position(5, 4);
        Position pos3 = new Position(4, 4);
        
        assertTrue(pos1.equals(pos3));
        assertFalse(pos1.equals(pos2));
        assertFalse(pos3.equals(pos2));
        assertTrue(pos1.equals(pos2.next(Direction.S)));
    }
    
}
