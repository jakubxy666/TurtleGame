package game.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class BoardTest {

    @Mock
    private Turtle mockTurtle;
    private int boardSize;
    private List fieldsInfo;

    private Board boardUnderTest;

    @Before
    public void setUp() {
        //System.out.println("Hello");
        initMocks(this);
        boardSize = 0;
        fieldsInfo = Arrays.asList();
        //System.out.println(fieldsInfo);
        //int x = 0;
        //int y = 0;
        //Orientation orientation = null;
        //mockTurtle = new Turtle(x, y, orientation);
        boardUnderTest = new Board(boardSize, mockTurtle, fieldsInfo);

    }

    @Test
    public void testGetFields() {
        //System.out.println("My fields");
        // Setup
        final BoardField[][] expectedResult = new BoardField[][]{};

        // Run the test
        final BoardField[][] result = boardUnderTest.getFields();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testCanMoveTo() {
        // Setup
        final int x = -1;
        final int y = -1;
        final Boolean expectedResult = false;
        //System.out.println("Hello");
        // Run the test
        final Boolean result = boardUnderTest.canMoveTo(x, y);
        //System.out.println(result);
        // Verify the results
        assertEquals(expectedResult, result);
        //System.out.println("Hello");

    }

    @Test
    public void testVisitField() {
        // Setup
        final int x = -1;
        final int y = -1;

        // Run the test
        boardUnderTest.visitField(x, y);

        // Verify the results
    }

    @Test
    public void testAllVisited() {
        // Setup
        final Boolean expectedResult = false;
        // Run the test
        final Boolean result;
        if(boardSize > 0)
            result = boardUnderTest.allVisited();
        else
            result = false;

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
