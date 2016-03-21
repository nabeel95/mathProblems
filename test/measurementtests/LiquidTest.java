package measurementtests;

import exception.IncompatibleTypeException;
import measurement.Length;
import measurement.Liquid;
import measurement.Measurement;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class LiquidTest {

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
    public void isEqual_should_compare_two_different_liquid_units() throws IncompatibleTypeException {
        Measurement _2_gallon = new Measurement(2.0, Liquid.gallon);
        Measurement _7point_56_litre = new Measurement(7.56, Liquid.litre);
        assertEquals(true, _7point_56_litre.isEqual(_2_gallon));
    }

    @Test
    public void one_gallon_should_be_equal_to_one_gallon() throws IncompatibleTypeException {
        Measurement _1_gallon = new Measurement(1, Liquid.gallon);
        assertEquals(true, _1_gallon.isEqual(_1_gallon));
    }

    @Test
    public void one_gallon_should_not_be_equal_to_one_ltr() throws IncompatibleTypeException {
        Measurement _1_gallon = new Measurement(1, Liquid.gallon);
        Measurement _1_litre = new Measurement(1, Liquid.litre);
        assertEquals(false, _1_gallon.isEqual(_1_litre));
    }

    @Test
    public void one_gallon_should_be_equal_to_3780_litres() throws IncompatibleTypeException {
        Measurement _1_gallon = new Measurement(1.0, Liquid.gallon);
        Measurement _3point78_litre = new Measurement(3.78, Liquid.litre);
        assertEquals(true, _3point78_litre.isEqual(_1_gallon));
    }

    @Test
    public void one_gallon_plus_one_gallon_should_be_two_gallon() throws IncompatibleTypeException {
        Measurement _1_gallon = new Measurement(1, Liquid.gallon);
        Measurement _2_gallon = new Measurement(2, Liquid.gallon);
        assertEquals(true, _2_gallon.isEqual(_1_gallon.addInto(_1_gallon)));
    }

    @Test
    public void one_litre_plus_one_litre_should_be_two_litre() throws IncompatibleTypeException {
        Measurement _1_litre = new Measurement(1, Liquid.litre);
        Measurement _2_litre = new Measurement(2, Liquid.litre);
        assertEquals(true, _2_litre.isEqual(_1_litre.addInto(_1_litre)));
    }

    @Test
    public void one_gallon_plus_3point78_ltr_should_be_2_gallon() throws IncompatibleTypeException {
        Measurement _1_gallon = new Measurement(1, Liquid.gallon);
        Measurement _3point78_litre = new Measurement(3.78, Liquid.litre);
        Measurement _2_gallon = new Measurement(2, Liquid.gallon);
        assertEquals(true, _2_gallon.isEqual(_1_gallon.addInto(_3point78_litre)));
    }
}
