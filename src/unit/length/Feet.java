package unit.length;

import exception.NonPositiveNumberException;

public class Feet implements Unit {
    private double value;

    private Feet(double value) {
        this.value = value;
    }

    public static Feet create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Feet(value);
    }

    @Override
    public double convertIntoBaseUnitAsMm() {
        return this.value * 12 * 25.4;
    }

    @Override
    public boolean isEqualTo(Unit unit) {
        return unit.convertIntoBaseUnitAsMm() == convertIntoBaseUnitAsMm();
    }

    @Override
    public Unit addWith(Unit unit) {
        return new Feet((unit.convertIntoBaseUnitAsMm() + convertIntoBaseUnitAsMm())/(12 * 25.4));
    }

}
