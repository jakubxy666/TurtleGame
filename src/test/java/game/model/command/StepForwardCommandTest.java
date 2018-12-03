package game.model.command;

import game.model.Board;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class StepForwardCommandTest {

    @Mock
    private Board mockB;

    private StepForwardCommand stepForwardCommandUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        stepForwardCommandUnderTest = new StepForwardCommand(mockB);
    }

    @Test
    public void testExecute() {
        // Setup
        final boolean expectedResult = false;

        // Run the test
        final boolean result = stepForwardCommandUnderTest.execute();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUndo() {
        // Setup

        // Run the test
        stepForwardCommandUnderTest.undo();

        // Verify the results
    }

    @Test
    public void testGetName() {
        // Setup
        final String expectedResult = "result";

        // Run the test
        final String result = stepForwardCommandUnderTest.getName();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
