
import exception.InvalidProbabilityException;
import exception.NonPositiveNumberException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import probability.Chance;
import rectangle.Rectangle;

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
    public void subtract_should_subtract_chance_value_from_provided_value() throws InvalidProbabilityException {
        Chance otherChance = chance.subtract(1);
        assertTrue(chance.equals(otherChance));
    }

    @Test
    public void add_should_add_two_chance_object_value_and_return_back_added_chance_objcet() throws InvalidProbabilityException {
        Chance otherChance = Chance.createChance(0.75);
        Chance addedChance = this.chance.add(otherChance);
        Chance expected = Chance.createChance(0.375);
        assertTrue(expected.equals(addedChance));
    }
}