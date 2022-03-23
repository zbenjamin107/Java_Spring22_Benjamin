import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import java.awt.Color;
public class CellTest {
    private Cell.states state;
    private Color color;
    private Cell cell;
    public static enum states {EMPTY,TREE,BURNING};// states of a cell 
    public static Color[] colors = {Color.YELLOW, Color.GREEN, Color.RED};// colors that resemnble cell states
    
    @BeforeEach 
    public void setUp(){
        cell = new Cell();// create a new cell for each method
    }                     // note: the color and state should be null bc no arguments were passed
    
    @Test 
    public void testGetState(){
        setUp();
        state = cell.getState();// get the state which is null 
        assertEquals(null, state);
    }
    
    
    @Test
    public void testSetState(){
        setUp();
        cell.setState(Cell.states.BURNING);// set the state from null to buring
        assertEquals(cell.getState(),Cell.states.BURNING);// make sure the state equals burning
    }

    @Test 
    public void testGetColor(){
        setUp();
        color = cell.getColor();// color should be null by the default constructor 
        assertEquals(color, null);// test the color was set to null 
    }
    
}
