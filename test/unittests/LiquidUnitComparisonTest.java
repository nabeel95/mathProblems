package unittests;

import exception.NonCompatibleTypeComparisonException;
import exception.NonPositiveNumberException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unit.length.Inch;
import unit.length.LengthUnit;
import unit.liquid.Gallon;
import unit.liquid.Litre;
import unit.liquid.LiquidUnit;

import static org.junit.Assert.*;

public class LiquidUnitComparisonTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsExceptionIfNonPositiveNumberProvided() throws NonPositiveNumberException {
        thrown.expect(NonPositiveNumberException.class);
        thrown.expectMessage("Expected positive number but received, non positive numbers");
        LiquidUnit unit = Litre.create(-2);
    }

    @Test
    public void one_gallon_should_be_equal_to_3point78lts() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LiquidUnit gallon = Gallon.create(1);
        LiquidUnit litre = Litre.create(3.78);
        assertTrue(gallon.isEqualTo(litre));
    }
    @Test
    public void three_point78lts_should_be_equal_to_1_gallon() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LiquidUnit gallon = Gallon.create(1);
        LiquidUnit litre = Litre.create(3.78);
        assertTrue(litre.isEqualTo(gallon));
    }
    @Test
    public void one_gallon_should_be_equal_to_one_gallon() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LiquidUnit gallon1 = Gallon.create(1);
        LiquidUnit gallon2 = Gallon.create(1);
        assertTrue(gallon1.isEqualTo(gallon2));
    }
    @Test
    public void one_litre_should_be_equal_to_one_litre() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LiquidUnit litre1 = Litre.create(1);
        LiquidUnit litre2 = Litre.create(1);
        assertTrue(litre1.isEqualTo(litre2));
    }

    @Test
    public void one_gallon_plus_one_litres_should_be_equal_to_4point_78_litres() throws NonPositiveNumberException, NonCompatibleTypeComparisonException {
        LiquidUnit litre = Litre.create(1);
        LiquidUnit gallon = Gallon.create(1);
        LiquidUnit expected = Litre.create(4.78);
        assertTrue(expected.isEqualTo(litre.addWith(gallon)));
    }


    @Test
    public void isEqualsToThrowsExceptionQuantityTypesAreNotSame() throws NonCompatibleTypeComparisonException, NonPositiveNumberException {
        thrown.expect(NonCompatibleTypeComparisonException.class);
        thrown.expectMessage("Units are not same");
        LiquidUnit litre = Litre.create(1);
        LengthUnit inch = Inch.create(1);
        boolean equalTo = litre.isEqualTo(inch);
    }
}
