import exception.NonPositiveNumberException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import square.Square;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void calculateAreaShouldCalculateAreaOfSquareOfGivenSize() throws NonPositiveNumberException {
        Square square = Square.create(5);
        assertEquals(25,square.calculateArea(),0.0);
    }

    @Test
    public void calculatePerimeterShouldCalculatePerimeterOfSquareOfGivenSize() throws NonPositiveNumberException {
        Square square =  Square.create(5);
        assertEquals(20,square.calculatePerimeter(),0.0);
    }

    @Test (expected = NonPositiveNumberException.class)
    public void throwsExceptionWhenNegativeNumbersAreGiven() throws NonPositiveNumberException {
        Square square = Square.create(0);
    }

    @Test
    public void throwsNonPositiveExceptionIfNonPositiveNumberProvided() throws NonPositiveNumberException {
        thrown.expect(NonPositiveNumberException.class);
        thrown.expectMessage("Expected positive number but received, non positive numbers");
        Square square = Square.create(-2);
    }
}
