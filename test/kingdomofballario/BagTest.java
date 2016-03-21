package kingdomofballario;

import KingdomOfBallario.Bag;
import KingdomOfBallario.Ball;
import KingdomOfBallario.Colour;
import exception.BagIsFullException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BagTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_exception_while_quantity_goes_more_than_three_green_balls() {
        Bag bag = new Bag();
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));

        thrown.expect(BagIsFullException.class);
        thrown.expectMessage("Bag rule doesn't allow 3 < green balls");
        bag.addBall(new Ball(Colour.GREEN));


    }

    @Test
    public void bag_should_not_allow_to_hold_3_red_when_greens_are_2() throws BagIsFullException {

        Bag bag = new Bag();

        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        int expectedSize = bag.addBall(new Ball(Colour.RED));

        assertEquals(5, expectedSize);
        thrown.expect(BagIsFullException.class);
        thrown.expectMessage("Bag rule doesn't allow more or equal to double of green");
        bag.addBall(new Ball(Colour.RED));

    }

    @Test
    public void bag_Should_not_allow_red_ball_in_beginning() {
        thrown.expect(BagIsFullException.class);
        thrown.expectMessage("Bag rule doesn't allow more or equal to double of green");
        Bag bag = new Bag();

        bag.addBall(new Ball(Colour.RED));
    }

    @Test
    public void bag_Should_not_allow_double_number_of_red_ball_than_green() {
        Bag bag = new Bag();
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.RED));

        thrown.expect(BagIsFullException.class);
        thrown.expectMessage("Bag rule doesn't allow more or equal to double of green");

        bag.addBall(new Ball(Colour.RED));
    }

    @Test
    public void bag_should_allow_any_number_of_blue_balls_that_bag_can_contain() {
        Bag bag = new Bag();
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));

        bag.addBall(new Ball(Colour.BLUE));
        bag.addBall(new Ball(Colour.BLUE));
        bag.addBall(new Ball(Colour.BLUE));
        bag.addBall(new Ball(Colour.BLUE));
        bag.addBall(new Ball(Colour.BLUE));
        bag.addBall(new Ball(Colour.BLUE));
        int expectedSize = bag.addBall(new Ball(Colour.BLUE));
        assertEquals(12, expectedSize);

        thrown.expect(BagIsFullException.class);
        bag.addBall(new Ball(Colour.BLUE));

    }
}
