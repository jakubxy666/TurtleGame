package game.model;

import org.junit.Before;

public class BoardFieldTest {

    private boolean visible;

    private BoardField boardFieldUnderTest;

    @Before
    public void setUp() {
        visible = false;
        boardFieldUnderTest = new BoardField(visible);
    }
}
