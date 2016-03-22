package kingdomofballario;

import KingdomOfBallario.Ball;
import KingdomOfBallario.Colour;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BallTest {
    @Test
    public void isOfColour_blue_should_be_true_if_the_colour_of_ball_is_blue() {
        Ball blueBall = new Ball(Colour.BLUE);
        assertTrue(blueBall.isOfColour(Colour.BLUE));
    }

    @Test
    public void isOfColour_blue_should_be_false_if_the_colour_of_ball_is_green() {
        Ball greenBall = new Ball(Colour.GREEN);
        assertFalse(greenBall.isOfColour(Colour.BLUE));
    }
}
