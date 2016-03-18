
import exception.InvalidProbabilityException;
import org.junit.Test;
import probability.Chance;
import probability.Probability;

import static org.junit.Assert.assertTrue;

public class ProbabilityTest {
    @Test
    public void probability_gives_probability_of_occuring_tail_while_single_coin_is_tossed_once() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(1,2);
        Chance chanceOfOccurence = probabilityCalculator.getOccuringProbability();
        Chance chance = Chance.createChance(0.5);
        assertTrue(chanceOfOccurence.equals(chance));
    }

    @Test
    public void probability_gives_probability_of_occuring_head_while_single_coin_is_tossed_once() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(1,2);
        Chance chanceOfNotOccurring = probabilityCalculator.getNotOccuringProbability();
        Chance chance = Chance.createChance(0.5);
        assertTrue(chanceOfNotOccurring.equals(chance));
    }

    @Test
    public void probability_gives_probability_of_occuring_head_while_two_coins_are_tossed() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(2,4);
        Chance chanceOfOccurring = probabilityCalculator.getProbabilityOfGettingSameEvent();
        Chance chance = Chance.createChance(0.25);
        assertTrue(chanceOfOccurring.equals(chance));
    }

    @Test
    public void probability_should_calculate_chance_of_getting_atleast_one_tail_when_flipping_two_coins() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(2,4);
        Chance chanceOfOccurring = probabilityCalculator.getProbabilityOfGettingAtLeastOneEvent();
        Chance chance = Chance.createChance(0.75);
        assertTrue(chanceOfOccurring.equals(chance));
    }
}