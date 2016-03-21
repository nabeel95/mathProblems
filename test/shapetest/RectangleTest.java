package shapetest;

import exception.NonPositiveNumberException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import rectangle.Rectangle;

import static junit.framework.TestCase.assertEquals;


public class RectangleTest {

    public Rectangle rectangleWithDecimalValues;
    public Rectangle rectangleWithFloatValues;
    public Rectangle rectangleWithNonPositiveValues;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() throws NonPositiveNumberException {
        rectangleWithDecimalValues = Rectangle.create(5,10);
        rectangleWithFloatValues = Rectangle.create(10.5,5.5);
    }

    @Test
    public void getAreaShouldBeAbleToCalculateAreaOfRectangleWhenDimensionsAreInDecimal() {
        assertEquals(50.0, rectangleWithDecimalValues.calculateArea());
    }

    @Test
    public void getPerimeterShouldBeAbleToCalculatePerimeterOfRectangleWhenDimensionsAreInDecimal() {
        assertEquals(30.0, rectangleWithDecimalValues.calculatePerimeter());
    }

    @Test
    public void getAreaShouldBeAbleToCalculateAreaForFractionalValues() {
        assertEquals(57.75, rectangleWithFloatValues.calculateArea());
    }

    @Test
    public void getPerimeterShouldBeAbleToCalculatePerimeterOfRectangleForFractionalValues() {
        assertEquals(32.0, rectangleWithFloatValues.calculatePerimeter());
    }

    @Test (expected = NonPositiveNumberException.class)
    public void throwsExceptionWhenNegativeNumbersAreGiven() throws NonPositiveNumberException {
        rectangleWithNonPositiveValues = Rectangle.create(-2, -3);
    }

    @Test
    public void throwsExceptionIfNonPositiveNumberProvided() throws NonPositiveNumberException {
        thrown.expect(NonPositiveNumberException.class);
        thrown.expectMessage("Expected positive number but received, non positive numbers");
        Rectangle rectangle = Rectangle.create(-2,-2);
    }
}
