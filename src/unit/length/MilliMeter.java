package unit.length;

import exception.NonPositiveNumberException;

public class MilliMeter extends LengthUnit {

    private double multiplier;

    private MilliMeter(double value, double multiplier) {
        super(value, 1);
        this.multiplier = multiplier;
    }

    public static MilliMeter create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new MilliMeter(value, 1);
    }
    @Override
    public LengthUnit addWith(LengthUnit unit) {
        return new MilliMeter(unit.convertIntoBaseUnit() + convertIntoBaseUnit(), multiplier);
    }
}
