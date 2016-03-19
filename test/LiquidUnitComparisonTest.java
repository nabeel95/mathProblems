import exception.NonPositiveNumberException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unit.liquid.Gallon;
import unit.liquid.Litre;
import unit.liquid.Unit;

import static org.junit.Assert.*;

public class LiquidUnitComparisonTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsExceptionIfNonPositiveNumberProvided() throws NonPositiveNumberException {
        thrown.expect(NonPositiveNumberException.class);
        thrown.expectMessage("Expected positive number but received, non positive numbers");
        Unit unit = Litre.create(-2);
    }

    @Test
    public void one_gallon_should_be_equal_to_3point78lts() throws NonPositiveNumberException {
        Unit gallon = Gallon.create(1);
        Unit litre = Litre.create(3.78);
        assertTrue(gallon.isEqualTo(litre));
    }
    @Test
    public void three_point78lts_should_be_equal_to_1_gallon() throws NonPositiveNumberException {
        Unit gallon = Gallon.create(1);
        Unit litre = Litre.create(3.78);
        assertTrue(litre.isEqualTo(gallon));
    }
    @Test
    public void one_gallon_should_be_equal_to_one_gallon() throws NonPositiveNumberException {
        Unit gallon1 = Gallon.create(1);
        Unit gallon2 = Gallon.create(1);
        assertTrue(gallon1.isEqualTo(gallon2));
    }
    @Test
    public void one_litre_should_be_equal_to_one_litre() throws NonPositiveNumberException {
        Unit litre1 = Litre.create(1);
        Unit litre2 = Litre.create(1);
        assertTrue(litre1.isEqualTo(litre2));
    }
}
