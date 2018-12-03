package game.controller;

import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;

public class GameAppControllerTest {

    @Mock
    private Stage mockPrimaryStage;

    private GameAppController gameAppControllerUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        gameAppControllerUnderTest = new GameAppController(mockPrimaryStage);
    }

    @Test
    public void testInitRootLayout() {
        // Setup

        // Run the test
        gameAppControllerUnderTest.initRootLayout();

        // Verify the results
    }
}
