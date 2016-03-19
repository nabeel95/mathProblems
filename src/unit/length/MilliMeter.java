package unit.length;

import exception.NonPositiveNumberException;

public class MilliMeter implements Unit{
    private double value;

    private MilliMeter(double value) {
        this.value = value;
    }

    public static MilliMeter create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new MilliMeter(value);
    }

    @Override
    public double convertIntoBaseUnitAsMm() {
        return value;
    }

    @Override
    public boolean isEqualTo(Unit unit) {
        return unit.convertIntoBaseUnitAsMm() == convertIntoBaseUnitAsMm();
    }

    @Override
    public Unit addWith(Unit unit) {
        return new MilliMeter(unit.convertIntoBaseUnitAsMm() + convertIntoBaseUnitAsMm());
    }
}
