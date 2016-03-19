package unit.length;

import exception.NonPositiveNumberException;

public class Feet extends LengthUnit {
    private double multiplier;

    private Feet(double value, double multiplier) {
        super(value, multiplier);
        this.multiplier = multiplier;
    }

    public static Feet create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Feet(value, 12 * 25.4);
    }
    @Override
    public LengthUnit addWith(LengthUnit unit) {
        return new Feet((unit.convertIntoBaseUnit() + convertIntoBaseUnit())/multiplier, multiplier);
    }
}
