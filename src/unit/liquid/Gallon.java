package unit.liquid;

import exception.NonPositiveNumberException;

public class Gallon implements Unit {


    private double value;

    private Gallon(double value) {
        this.value = value;
    }

    @Override
    public double convertIntoBaseUnitAsLtr() {
        return 3780 * value;
    }

    public static Gallon create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Gallon(value);
    }

    @Override
    public boolean isEqualTo(Unit unit) {
        return unit.convertIntoBaseUnitAsLtr() == convertIntoBaseUnitAsLtr();
    }
}
