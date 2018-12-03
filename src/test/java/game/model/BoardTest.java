package game.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class BoardTest {

    @Mock
    private Turtle mockTurtle;
    private BoardField[][] fields;

    private Board boardUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        fields = new BoardField[][]{};
        boardUnderTest = new Board(mockTurtle, fields);
    }

    @Test
    public void testGetFields() {
        // Setup
        final BoardField[][] expectedResult = new BoardField[][]{};

        // Run the test
        final BoardField[][] result = boardUnderTest.getFields();

        // Verify the results
        assertArrayEquals(expectedResult, result);
    }
}
