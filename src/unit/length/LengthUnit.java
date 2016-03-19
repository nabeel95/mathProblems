package unit.length;

import exception.NonCompatibleTypeComparisonException;
import unit.Unit;

public abstract class LengthUnit implements Unit{
    private double value;
    private double multiplier;

    public LengthUnit(double value, double multiplier) {
        this.value = value;
        this.multiplier = multiplier;
    }

    public double convertIntoBaseUnit(){
        return value * multiplier;
    }

    public boolean isEqualTo(Unit unit) throws NonCompatibleTypeComparisonException {
        if(!(unit instanceof LengthUnit)) throw new NonCompatibleTypeComparisonException();
        return unit.convertIntoBaseUnit() == convertIntoBaseUnit();
    }

    public abstract LengthUnit addWith(LengthUnit unit);
}
