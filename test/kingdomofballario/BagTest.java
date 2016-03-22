package kingdomofballario;

import KingdomOfBallario.Bag;
import KingdomOfBallario.Ball;
import KingdomOfBallario.Colour;
import exception.BagRuleException;
import org.junit.Assert;
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

        thrown.expect(BagRuleException.class);
        thrown.expectMessage("Bag rule doesn't allow 3 < green balls");
        bag.addBall(new Ball(Colour.GREEN));


    }

    @Test
    public void bag_should_not_allow_to_keep_3_red_balls_when_greens_are_2() throws BagRuleException {

        Bag bag = new Bag();

        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));

        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        int expectedSize = bag.addBall(new Ball(Colour.RED));

        assertEquals(5, expectedSize);
        thrown.expect(BagRuleException.class);
        thrown.expectMessage("Bag rule doesn't allow more or equal to double of green");
        bag.addBall(new Ball(Colour.RED));

    }

    @Test
    public void bag_Should_not_allow_red_ball_in_beginning() {
        thrown.expect(BagRuleException.class);
        thrown.expectMessage("Bag rule doesn't allow more or equal to double of green");
        Bag bag = new Bag();

        bag.addBall(new Ball(Colour.RED));
    }

    @Test
    public void bag_Should_not_allow_double_number_of_red_ball_than_green() {
        Bag bag = new Bag();
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.RED));

        thrown.expect(BagRuleException.class);
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

        thrown.expect(BagRuleException.class);
        thrown.expectMessage("Bag is full");
        bag.addBall(new Ball(Colour.BLUE));
    }

    @Test
    public void add_should_throw_exception_when_more_than_40_percent_yellow_balls_being_added() {
        Bag bag = new Bag();
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.YELLOW));
        bag.addBall(new Ball(Colour.YELLOW));

        thrown.expect(BagRuleException.class);
        thrown.expectMessage("Bag rule doesn't allow more than 40% of yellow balls of total balls");
        bag.addBall(new Ball(Colour.YELLOW));
    }

    @Test
    public void bagSummary_should_give_summary_with_numbers_of_each_colour_balls() {
        Bag bag = new Bag();
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.GREEN));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.RED));
        bag.addBall(new Ball(Colour.YELLOW));
        bag.addBall(new Ball(Colour.YELLOW));

        String expectedSummary = "Balls : 7\nGreen : 2\nRed : 3\nYellow : 2\nBlue : 0";
        Assert.assertEquals(expectedSummary,bag.showSummary());

    }
}
