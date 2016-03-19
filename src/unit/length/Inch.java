package unit.length;

import exception.NonPositiveNumberException;

public class Inch implements Unit {
    private final double value;

    private Inch(double value) {
        this.value = value;
    }

    public static Inch create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Inch(value);
    }

    @Override
    public double convertIntoBaseUnitAsMm() {
        return this.value * 25.4;
    }

    @Override
    public boolean isEqualTo(Unit unit) {
        return unit.convertIntoBaseUnitAsMm() == convertIntoBaseUnitAsMm();
    }

    @Override
    public Unit addWith(Unit unit) {
        return new Inch(Math.ceil((unit.convertIntoBaseUnitAsMm() + convertIntoBaseUnitAsMm())/25.4));
    }
}
