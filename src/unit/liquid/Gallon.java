package unit.liquid;

import exception.NonPositiveNumberException;

public class Gallon extends LiquidUnit {
    private double multiplier;
    private Gallon(double value, double multiplier) {
        super(value, multiplier);
        this.multiplier = multiplier;
    }


    public static Gallon create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Gallon(value, 3780);
    }

    @Override
    public LiquidUnit addWith(LiquidUnit unit) {
        return new Gallon((unit.convertIntoBaseUnit() + convertIntoBaseUnit())/multiplier, multiplier);
    }
}
