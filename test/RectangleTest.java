import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class RectangleTest {

    public Rectangle rectangleWithDecimalValues;
    public Rectangle rectangleWithFloatValues;

    @Before
    public void setup(){
        rectangleWithDecimalValues = Rectangle.createRectangle(5,10);
        rectangleWithFloatValues = Rectangle.createRectangle(10.5,5.5);
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
}
