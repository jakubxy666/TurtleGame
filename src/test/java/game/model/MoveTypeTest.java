package game.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class MoveTypeTest {

    @Test
    public void testForward() {
        // Setup
        final Orientation o = Orientation.N;
        final MoveType expectedResult = MoveType.Up;

        // Run the test
        final MoveType result = MoveType.forward(o);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testRotate() {
        // Setup
        final Orientation from = Orientation.E;
        final Orientation to = Orientation.N;
        final MoveType expectedResult = MoveType.RLeft;

        // Run the test
        final MoveType result = MoveType.rotate(from, to);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
