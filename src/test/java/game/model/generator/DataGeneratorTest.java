package game.model.generator;

import game.model.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataGeneratorTest {

    @Test
    public void testGenerateGameData() {
        // Setup
        final int lvl = 0;
        final Board expectedResult = null;

        // Run the test
        final Board result = DataGenerator.generateGameData(lvl);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
