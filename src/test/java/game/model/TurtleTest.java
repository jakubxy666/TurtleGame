package game.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurtleTest {

    private int x;
    private int y;
    private Orientation orientation;

    private Turtle turtleUnderTest;

    @Before
    public void setUp() {
        x = 0;
        y = 0;
        orientation = Orientation.E;
        turtleUnderTest = new Turtle(x, y, orientation);
    }

    @Test
    public void testGetX() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = turtleUnderTest.getX();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetX() {
        // Setup
        final int x = 0;

        // Run the test
        turtleUnderTest.setX(x);

        // Verify the results
    }

    @Test
    public void testGetY() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = turtleUnderTest.getY();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetY() {
        // Setup
        final int y = 0;

        // Run the test
        turtleUnderTest.setY(y);

        // Verify the results
    }

    @Test
    public void testGetOrientation() {
        // Setup
        final Orientation expectedResult = Orientation.E;

        // Run the test
        final Orientation result = turtleUnderTest.getOrientation();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetOrientation() {
        // Setup
        final Orientation orientation = null;

        // Run the test
        turtleUnderTest.setOrientation(orientation);

        // Verify the results
    }

    @Test
    public void testWipeMemory() {
        // Setup

        // Run the test
        turtleUnderTest.wipeMemory();

        // Verify the results
    }

    @Test
    public void testRotateTo() {
        // Setup
        final Orientation orientation = Orientation.N;

        // Run the test
        turtleUnderTest.rotateTo(orientation);

        // Verify the results
    }

    @Test
    public void testMoveTo() {
        // Setup
        final int x = 0;
        final int y = 0;

        // Run the test
        turtleUnderTest.moveTo(x, y);

        // Verify the results
    }
}
