package game.model.command;

import game.model.Turtle;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class TurnLeftCommandTest {

    @Mock
    private Turtle mockT;

    private TurnLeftCommand turnLeftCommandUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        turnLeftCommandUnderTest = new TurnLeftCommand(mockT);
    }

    @Test
    public void testExecute() {
        // Setup
        final boolean expectedResult = false;

        // Run the test
        final boolean result = turnLeftCommandUnderTest.execute();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUndo() {
        // Setup

        // Run the test
        turnLeftCommandUnderTest.undo();

        // Verify the results
    }

    @Test
    public void testGetName() {
        // Setup
        final String expectedResult = "result";

        // Run the test
        final String result = turnLeftCommandUnderTest.getName();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
