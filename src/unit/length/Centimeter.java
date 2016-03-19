package unit.length;

import exception.NonPositiveNumberException;

public class Centimeter implements Unit {

    private double value;

    private Centimeter(double value) {
        this.value = value;
    }

    public static Centimeter create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Centimeter(value);
    }

    @Override
    public double convertIntoBaseUnitAsMm() {
        return this.value * 10;
    }

    @Override
    public boolean isEqualTo(Unit unit) {
        return unit.convertIntoBaseUnitAsMm() == convertIntoBaseUnitAsMm();
    }

    @Override
    public Unit addWith(Unit unit) {
        return new Centimeter(Math.ceil((unit.convertIntoBaseUnitAsMm() + convertIntoBaseUnitAsMm())/10));
    }
}
