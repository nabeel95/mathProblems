package unittests;

import exception.NonCompatibleTypeComparisonException;
import exception.NonPositiveNumberException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import unit.length.LengthUnit;
import unit.length.*;
import static org.junit.Assert.*;


public class LengthUnitComparisonTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsExceptionIfNonPositiveNumberProvided() throws NonPositiveNumberException {
        thrown.expect(NonPositiveNumberException.class);
        thrown.expectMessage("Expected positive number but received, non positive numbers");
        LengthUnit unit = Feet.create(-2);
    }

    @Test
    public void one_ft_should_be_equal_to_twelve_inches() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit inch = Inch.create(12);
        LengthUnit feet = Feet.create(1);
        assertTrue(feet.isEqualTo(inch));
    }

    @Test
    public void twelve_inches_should_be_equal_to_one_feet() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit inch =  Inch.create(12);
        LengthUnit feet =  Feet.create(1);
        assertTrue(inch.isEqualTo(feet));
    }

    @Test
    public void twelve_inches_should_be_equal_to_twelve_inches() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit inch1 =  Inch.create(12);
        LengthUnit inch2 =  Inch.create(12);
        assertTrue(inch1.isEqualTo(inch2));
    }

    @Test
    public void one_inch_should_be_equal_to_2Point_54_centimeters () throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit inch =  Inch.create(1);
        LengthUnit centimeter =  Centimeter.create(2.54);
        assertTrue(inch.isEqualTo(centimeter));
    }

    @Test
    public void one_centimeters_should_not_be_equal_to_two_centimeter() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit cm1 =  Centimeter.create(1);
        LengthUnit cm2 =  Centimeter.create(2);
        assertFalse(cm1.isEqualTo(cm2));
    }

    @Test
    public void one_centimeteres_should_be_equal_to_10_milimeter() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit cm =  Centimeter.create(1);
        LengthUnit mm =  MilliMeter.create(10);
        assertTrue(cm.isEqualTo(mm));
    }

    @Test
    public void millimeter_should_be_equal_to_millimeter_if_value_is_same() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit mm1 =  MilliMeter.create(10);
        LengthUnit mm2 =  MilliMeter.create(10);
        assertTrue(mm1.isEqualTo(mm2));
    }

    @Test
    public void add_should_be_able_to_add_two_same_units() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit inch_12 =  Inch.create(12);
        LengthUnit another_inch_12 =  Inch.create(12);
        LengthUnit Expected = Inch.create(24);
        LengthUnit actual = inch_12.addWith(another_inch_12);
        assertTrue(Expected.isEqualTo(actual));
    }

    @Test
    public void add_should_be_able_to_add_two_different_units() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LengthUnit inch =  Inch.create(2);
        LengthUnit centimeter =  Centimeter.create(2.5);
        LengthUnit Expected = Inch.create(3.0);
        LengthUnit actual = inch.addWith(centimeter);
        assertTrue(Expected.isEqualTo(actual));
    }
}
