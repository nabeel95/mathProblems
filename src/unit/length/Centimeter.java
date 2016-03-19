package unit.length;

import exception.NonPositiveNumberException;

public class Centimeter extends LengthUnit {

    private double multiplier;

    private Centimeter(double value, double multiplier) {
        super(value, multiplier);
        this.multiplier = multiplier;
    }

    public static Centimeter create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Centimeter(value, 10);
    }
    @Override
    public LengthUnit addWith(LengthUnit unit) {
        return new Centimeter(Math.ceil((unit.convertIntoBaseUnit() + convertIntoBaseUnit())/multiplier), multiplier);
    }
}
