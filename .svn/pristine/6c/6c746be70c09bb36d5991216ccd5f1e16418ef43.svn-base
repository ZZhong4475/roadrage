/**
 * Truck Test
 */


package tests;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;

public class TruckTest {
    /**
     * Static Variable for test loops.
     */
    private static final int TRIES_FOR_RANDOMNESS = 50;
    /**
     * Static variable for test class death time.
     */
    private static final int MY_DEATH_TIME = 30;
    /**
     * X variable for x coordinate.
     */
    private static final int MY_X = 10;
    /**
     * y cariable for y coordinate.
     */
    private static final int MY_Y = 10;
    /**
     * Direction variable for testing.
     */
    private static final Direction MY_DIRECTION = Direction.EAST;
    /**
     * Truck Class for testing.
     */
    private Truck myTestTruck;
    /**setUp Class.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
       
        myTestTruck = new Truck(MY_X, MY_Y, MY_DIRECTION);
        
    }

    /**
     * Test constructors with different state.
     */
    @Test
    public void testConstructor() {
        final int testX = 10;
        final int testY = 10;
        final Truck newTruck = new Truck(testX, testY, Direction.EAST);
        assertEquals("X coordinates should equal", newTruck.getX(), myTestTruck.getY());
        assertEquals("Y coordinates should equal", newTruck.getY(), myTestTruck.getY());
        assertEquals("Direction test", newTruck.getDirection(), myTestTruck.getDirection());
        assertEquals("DeathTime test ", newTruck.getDeathTime(), myTestTruck.getDeathTime());
        
        
        
    
        
        
    }
    
    /**
     * Test out the setter.
     */
    @Test
    public void testSetter() {
        final int setX = 19;
        final int setY = 20;
        final Direction setD = Direction.SOUTH;
        myTestTruck.setX(setX);
        myTestTruck.setY(setY);
        myTestTruck.setDirection(setD);
        assertEquals(" set x should return same values", setX, myTestTruck.getX());
        assertEquals("set y should return same values", setY, myTestTruck.getY());
        assertEquals("set D should return same values", setD, myTestTruck.getDirection());
    }
    
    /**
     * Test is the truck always alive.
     */
    @Test
    public void testAlive() {
        
        final boolean alive = true;
        assertEquals("Truck always alive", alive, myTestTruck.isAlive());
        
    }
    
    /**
     * Test truck pass with street light.
     */
    @Test
    public void testCanPassStreet() {

        assertTrue("can pass red street light", 
                   myTestTruck.canPass(Terrain.STREET, Light.RED));
        assertTrue("Truck can pass green street light"
                   , myTestTruck.canPass(Terrain.STREET, Light.GREEN));
        assertTrue("Truck can pass yellow street light" 
                  , myTestTruck.canPass(Terrain.STREET, Light.YELLOW));

    }
    /**
     * Test truck pass with traffic light.
     */
    @Test
    public void testCanPassTraffic() {

        assertTrue("Can pass red light", 
                   myTestTruck.canPass(Terrain.LIGHT, Light.RED));
        assertTrue("Can pass green traffic light"
                   , myTestTruck.canPass(Terrain.LIGHT, Light.GREEN));
        assertTrue(" Can pass yellow traffic light"
                   , myTestTruck.canPass(Terrain.LIGHT, Light.YELLOW));

    }

    /**
     * Test if the truck counter crosswalk light.
     */
    @Test
    public void testCanPassCross() {

        assertFalse("Truck can pass red traffic light"
                    , myTestTruck.canPass(Terrain.CROSSWALK, Light.RED));
        assertTrue("Truck can pass green traffic light"
                   , myTestTruck.canPass(Terrain.CROSSWALK, Light.GREEN));
        assertTrue("Truck can pass yellow traffic light"
                   , myTestTruck.canPass(Terrain.CROSSWALK, Light.YELLOW));

    }
    /**
     * Modify from Human Test for testing choosedirection.
     * @author Alan Fowler (acfowler@uw.edu).
     * 
     */
    @Test
    public void testChooseDirection() {

        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.SOUTH, Terrain.CROSSWALK);
        neighbors.put(Direction.NORTH, Terrain.STREET);
        neighbors.put(Direction.EAST, Terrain.LIGHT);
        neighbors.put(Direction.WEST, Terrain.GRASS);
        
       
        boolean seenWest = false;
        boolean seenNorth = false;
        boolean seenEast = false;
        boolean seenSouth = false;
        
        
        for (int count = 0; count < TRIES_FOR_RANDOMNESS; count++) {
            final Direction d = myTestTruck.chooseDirection(neighbors);
            
            if (d == Direction.WEST) {
                seenWest = true;
            } else if (d == Direction.EAST) {
                seenNorth = true;
            } else if (d == Direction.NORTH) {
                seenEast = true;
            } else if (d == Direction.SOUTH) { 
                seenSouth = true;
            }
        }
 
        assertTrue("Truck chooseDirection() fails to select randomly "
                   + "among all possible valid choices!",
                   seenSouth && seenNorth && seenEast);
            
        assertFalse("Truck chooseDirection() reversed direction when not necessary!",
                    seenWest);
        
        //to test for reverse, pass empty neighbor(map);
        neighbors.clear();
        assertEquals(Direction.WEST, myTestTruck.chooseDirection(neighbors)); 
        
    }
}
