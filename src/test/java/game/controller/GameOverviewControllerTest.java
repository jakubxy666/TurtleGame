package game.controller;

import game.model.Board;
import org.junit.Before;
import org.junit.Test;

public class GameOverviewControllerTest {

    private GameOverviewController gameOverviewControllerUnderTest;

    @Before
    public void setUp() {
        gameOverviewControllerUnderTest = new GameOverviewController();
    }

    @Test
    public void testUpdateCanvas() {
        // Setup

        // Run the test
        gameOverviewControllerUnderTest.updateCanvas();

        // Verify the results
    }

    // do that thing!

    @Test
    public void testSetData() {
        // Setup
        final Board board = null;

        // Run the test
        gameOverviewControllerUnderTest.setData(board);

        // Verify the results
    }
}
