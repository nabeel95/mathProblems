
import exception.InvalidProbabilityException;
import exception.NonPositiveNumberException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import probability.Chance;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChanceTest {

    private Chance chance;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test (expected = InvalidProbabilityException.class)
    public void throwsExceptionWhenNegativeNumbersAreGiven() throws InvalidProbabilityException {
        chance = Chance.createChance(1.1);
    }

    @Test
    public void throwsExceptionIfNonPositiveNumberProvided() throws InvalidProbabilityException {
        thrown.expect(InvalidProbabilityException.class);
        thrown.expectMessage("Invalid Probability. expected numbers between 0 & 1");
        Chance chance = Chance.createChance(2);
    }

    @Before
    public void setUp() throws InvalidProbabilityException {
        chance = Chance.createChance(0.5);
    }

    @Test
    public void two_chance_should_be_unequal_if_values_are_different() throws InvalidProbabilityException {
        Chance otherChance = Chance.createChance(0.6);
        assertFalse(chance.equals(otherChance));
    }

    @Test
    public void two_chance_should_be_equal_if_values_are_same() throws InvalidProbabilityException {
        Chance otherChance = Chance.createChance(0.5);
        assertTrue(chance.equals(otherChance));
    }

    @Test
    public void subtract_should_be_able_to_substract_two_different_chances() throws InvalidProbabilityException {
        Chance otherChance = chance.subtract(1);
        assertTrue(chance.equals(otherChance));
    }

    @Test
    public void add_should_be_able_to_add_two_different_chances() throws InvalidProbabilityException {
        Chance otherChance = Chance.createChance(0.2);
        Chance addedChance = this.chance.add(otherChance);
        Chance expected = Chance.createChance(0.1);
        assertTrue(expected.equals(addedChance));
    }
}