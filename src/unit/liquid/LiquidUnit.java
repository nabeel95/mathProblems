package unit.liquid;

import exception.NonCompatibleTypeComparisonException;
import unit.Unit;

public abstract class LiquidUnit implements Unit{

    private final double value;
    private final double multiplier;

    public LiquidUnit(double value, double multiplier) {
        this.value = value;
        this.multiplier = multiplier;
    }

    public double convertIntoBaseUnit(){
        return value * multiplier;
    }
    @Override
    public boolean isEqualTo(Unit unit) throws NonCompatibleTypeComparisonException {
        if(!(unit instanceof LiquidUnit)){
            throw new NonCompatibleTypeComparisonException();
        }
        return unit.convertIntoBaseUnit() == convertIntoBaseUnit();
    }
    public abstract LiquidUnit addWith(LiquidUnit unit);
}
