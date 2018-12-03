package game.model;

import game.model.command.ITurtleCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandSequenceTest {

    private BoardField[][] f;

    private CommandSequence commandSequenceUnderTest;

    @Before
    public void setUp() {
        f = new BoardField[][]{};
        commandSequenceUnderTest = new CommandSequence(f);
    }

    @Test
    public void testAddCommand() {
        // Setup
        final ITurtleCommand command = null;

        // Run the test
        commandSequenceUnderTest.addCommand(command);

        // Verify the results
    }

    @Test
    public void testRemoveLastCommand() {
        // Setup

        // Run the test
        commandSequenceUnderTest.removeLastCommand();

        // Verify the results
    }

    @Test
    public void testGetSize() {
        // Setup
        final int expectedResult = 0;

        // Run the test
        final int result = commandSequenceUnderTest.getSize();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testClear() {
        // Setup

        // Run the test
        commandSequenceUnderTest.clear();

        // Verify the results
    }

    @Test
    public void testExecute() {
        // Setup
        final String expectedResult = "result";

        // Run the test
        final String result = commandSequenceUnderTest.execute();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
