package unit.liquid;

import exception.NonPositiveNumberException;

public class Litre extends LiquidUnit {
    private double multiplier;

    private Litre(double value, double multiplier) {
        super(value, multiplier);
        this.multiplier = multiplier;
    }

    public static Litre create(double value) throws NonPositiveNumberException {
        if (value < 0)
            throw new NonPositiveNumberException();
        return new Litre(value, 1000);
    }
    @Override
    public LiquidUnit addWith(LiquidUnit unit) {
        return new Litre((unit.convertIntoBaseUnit() + convertIntoBaseUnit())/multiplier, multiplier);
    }
}
