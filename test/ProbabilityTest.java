
import exception.InvalidProbabilityException;
import org.junit.Test;
import probability.Chance;
import probability.Probability;

import static org.junit.Assert.assertTrue;

public class ProbabilityTest {
    @Test
    public void probability_should_calculate_chance_of_tail_getting_when_flipping_a_coin() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(1,2);
        Chance chanceOfEventOccurring = probabilityCalculator.getOccuringProbability();
        Chance chance = Chance.createChance(0.5);
        assertTrue(chanceOfEventOccurring.equals(chance));
    }

    @Test
    public void probability_should_calculate_chance_of_not_tail_getting_when_flipping_a_coin() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(1,2);
        Chance chanceOfNotEventOccurring = probabilityCalculator.getNotOccuringProbability();
        Chance chance = Chance.createChance(0.5);
        assertTrue(chanceOfNotEventOccurring.equals(chance));
    }

    @Test
    public void probability_should_calculate_chance_of_both_getting_tail_when_flipping_two_coins() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(2,4);
        Chance chanceOfEventOccurring = probabilityCalculator.getProbabilityOfGettingSameEvent();
        Chance chance = Chance.createChance(0.25);
        assertTrue(chanceOfEventOccurring.equals(chance));
    }

    @Test
    public void probability_should_calculate_chance_of_getting_atleast_one_tail_when_flipping_two_coins() throws InvalidProbabilityException {
        Probability probabilityCalculator = Probability.create(2,4);
        Chance chanceOfEventOccurring = probabilityCalculator.getProbabilityOfGettingAtLeastOneEvent();
        Chance chance = Chance.createChance(0.75);
        assertTrue(chanceOfEventOccurring.equals(chance));
    }
}