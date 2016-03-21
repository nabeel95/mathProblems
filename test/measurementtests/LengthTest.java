package measurementtests;

import exception.IncompatibleTypeException;
import measurement.Length;
import measurement.Liquid;
import measurement.Measurement;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class LengthTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_exception_while_adding_length_into_liquid() throws IncompatibleTypeException {
        thrown.expect(IncompatibleTypeException.class);
        thrown.expectMessage("Incompatible Units");
        Measurement _1_feet = new Measurement(1, Length.feet);
        Measurement _1_litre = new Measurement(1, Liquid.litre);
        Measurement expected = _1_feet.addInto(_1_litre);
    }

    @Test
    public void isEqual_should_compare_two_different_length_units() throws IncompatibleTypeException {
        Measurement _2_feet = new Measurement(2, Length.feet);
        Measurement _24_inch = new Measurement(24.0, Length.inch);
        assertEquals(_2_feet.isEqual(_24_inch), true);
    }

    @Test
    public void isEqual_should_compare_two_same_length_units() throws IncompatibleTypeException {
        Measurement _2_feet = new Measurement(2, Length.feet);
        assertEquals(_2_feet.isEqual(_2_feet), true);
    }

    @Test
    public void is_equal_should_be_able_to_compare_inch_and_centimeter() throws IncompatibleTypeException {
        Measurement _2_inch = new Measurement(2, Length.inch);
        Measurement _5point08_centimeter = new Measurement(5.08, Length.centimeter);
        assertEquals(true, _2_inch.isEqual(_5point08_centimeter));
    }

    @Test
    public void isEqual_should_compare_two_cm_with_twenty_mm() throws IncompatibleTypeException {
        Measurement _2_feet = new Measurement(2, Length.centimeter);
        Measurement _20_inch = new Measurement(20, Length.millimeter);
        assertEquals(true, _2_feet.isEqual(_20_inch));
    }

    @Test
    public void one_feet_and_one_inch_are_not_equal() throws IncompatibleTypeException {
        Measurement _1_feet = new Measurement(1, Length.feet);
        Measurement _1_inch = new Measurement(1, Length.inch);
        assertEquals(false, _1_feet.isEqual(_1_inch));
    }

    @Test
    public void two_feet_plus_two_feet_should_be_four_feet() throws IncompatibleTypeException {
        Measurement _2_feet = new Measurement(2, Length.feet);
        Measurement _4_feet = new Measurement(4, Length.feet);
        assertEquals(_4_feet, _2_feet.addInto(_2_feet));

    }
}
