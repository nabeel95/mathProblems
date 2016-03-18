import measurement.Centimeters;
import measurement.Feet;
import measurement.Inch;
import measurement.Unit;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitComparisonTest {

    @Test
    public void one_ft_should_be_equal_to_twelve_inches() {
        Unit inch = new Inch(12);
        Unit feet = new Feet(1);
        assertTrue(feet.equals(inch));
    }

    @Test
    public void twelve_inches_should_be_equal_to_one_feet() {
        Unit inch = new Inch(12);
        Unit feet = new Feet(1);
        assertTrue(inch.equals(feet));
    }


    @Test
    public void twelve_inches_should_be_equal_to_twelve_inches() {
        Unit inch1 = new Inch(12);
        Unit inch2 = new Inch(12);
        assertTrue(inch1.equals(inch2));
    }

    @Test
    public void one_inch_should_be_equal_to_2Point_54_centimeters () {
        Unit inch = new Inch(1);
        Unit centimeter = new Centimeters(2.54);
        assertTrue(inch.equals(centimeter));
    }

    @Test
    public void one_centimeters_should_not_be_equal_to_two_centimeter() {
        Unit cm1 = new Centimeters(1);
        Unit cm2 = new Centimeters(2);
        assertFalse(cm1.equals(cm2));
    }
}
