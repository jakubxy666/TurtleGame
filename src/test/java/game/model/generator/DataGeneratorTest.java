package game.model.generator;

import game.model.Board;
import game.model.BoardField;
import game.model.Orientation;
import game.model.Turtle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataGeneratorTest {

    private final static int boardSize = 5;
    private final static int[] visible = {10, 11, 12};

    @Test
    public void testGenerateGameData() {
        // Setup
        final Board expectedResult = null;
        Turtle turtle = new Turtle(0, 2, Orientation.E);
        BoardField[][] fields = new BoardField[boardSize][boardSize];

        // Run the test
        final Board result = DataGenerator.generateGameData();
        System.out.println(result);
        Turtle tur = result.getTurtle();
        int x = tur.getX();
        int y = tur.getY();
        //tur.getOrientation();

        // Verify the results
        //assertEquals(expectedResult, result);
        assertEquals(0, x);
        assertEquals(2, y);
    }

    @Test
    public void testArrContains() {
        // Setup
        final int[] arr = new int[]{};
        final int key = 0;
        final boolean expectedResult = false;

        // Run the test
        final boolean result = DataGenerator.arrContains(arr, key);

        // Verify the results
        assertEquals(expectedResult, result);

    }
}
