import exception.NonPositiveNumberException;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Test;
import unit.length.*;
import static org.junit.Assert.*;


public class LengthUnitComparisonTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsExceptionIfNonPositiveNumberProvided() throws NonPositiveNumberException {
        thrown.expect(NonPositiveNumberException.class);
        thrown.expectMessage("Expected positive number but received, non positive numbers");
        Unit unit = Feet.create(-2);
    }

    @Test
    public void one_ft_should_be_equal_to_twelve_inches() throws NonPositiveNumberException {
        Unit inch = Inch.create(12);
        Unit feet = Feet.create(1);
        assertTrue(feet.isEqualTo(inch));
    }

    @Test
    public void twelve_inches_should_be_equal_to_one_feet() throws NonPositiveNumberException {
        Unit inch =  Inch.create(12);
        Unit feet =  Feet.create(1);
        assertTrue(inch.isEqualTo(feet));
    }

    @Test
    public void twelve_inches_should_be_equal_to_twelve_inches() throws NonPositiveNumberException {
        Unit inch1 =  Inch.create(12);
        Unit inch2 =  Inch.create(12);
        assertTrue(inch1.isEqualTo(inch2));
    }

    @Test
    public void one_inch_should_be_equal_to_2Point_54_centimeters () throws NonPositiveNumberException {
        Unit inch =  Inch.create(1);
        Unit centimeter =  Centimeter.create(2.54);
        assertTrue(inch.isEqualTo(centimeter));
    }

    @Test
    public void one_centimeters_should_not_be_equal_to_two_centimeter() throws NonPositiveNumberException {
        Unit cm1 =  Centimeter.create(1);
        Unit cm2 =  Centimeter.create(2);
        assertFalse(cm1.isEqualTo(cm2));
    }

    @Test
    public void one_centimeteres_should_be_equal_to_10_milimeter() throws NonPositiveNumberException {
        Unit cm =  Centimeter.create(1);
        Unit mm =  MilliMeter.create(10);
        assertTrue(cm.isEqualTo(mm));
    }

    @Test
    public void millimeter_should_be_equal_to_millimeter_if_value_is_same() throws NonPositiveNumberException {
        Unit mm1 =  MilliMeter.create(10);
        Unit mm2 =  MilliMeter.create(10);
        assertTrue(mm1.isEqualTo(mm2));
    }

    @Test
    public void add_should_be_able_to_add_two_same_units() throws NonPositiveNumberException {
        Unit inch_12 =  Inch.create(12);
        Unit another_inch_12 =  Inch.create(12);
        Unit Expected = Inch.create(24);
        Unit actual = inch_12.addWith(another_inch_12);
        assertTrue(Expected.isEqualTo(actual));
    }

    @Test
    public void add_should_be_able_to_add_two_different_units() throws NonPositiveNumberException {
        Unit inch =  Inch.create(2);
        Unit centimeter =  Centimeter.create(2.5);
        Unit Expected = Inch.create(3.0);
        Unit actual = inch.addWith(centimeter);
        assertTrue(Expected.isEqualTo(actual));
    }
}
