package unit.length;

import exception.NonPositiveNumberException;

public class Inch extends LengthUnit {
    private double multiplier;

    private Inch(double value, double multiplier) {
        super(value, multiplier);
        this.multiplier = multiplier;
    }

    public static Inch create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Inch(value, 25.4);
    }

    @Override
    public LengthUnit addWith(LengthUnit unit) {
        return new Inch(Math.ceil((unit.convertIntoBaseUnit() + convertIntoBaseUnit()) / multiplier), multiplier);
    }
}
