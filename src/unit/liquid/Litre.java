package unit.liquid;

import exception.NonPositiveNumberException;

public class Litre implements Unit {
    private double value;

    private Litre(double value) {

        this.value = value;
    }

    public static Litre create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Litre(value);
    }

    @Override
    public double convertIntoBaseUnitAsLtr() {
        return 1000 * value;
    }

    @Override
    public boolean isEqualTo(Unit unit) {
        return unit.convertIntoBaseUnitAsLtr() == convertIntoBaseUnitAsLtr();
    }
}
