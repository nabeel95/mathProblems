package measurement;

public enum Liquid implements Unit {

    gallon(3780),
    litre(1000),
    milliliter(1);

    private double baseFactor;

    Liquid(double baseFactor) {
        this.baseFactor = baseFactor;
    }


    @Override
    public double baseFactor() {
        return baseFactor;
    }

    @Override
    public Unit baseUnit() {
        return Liquid.milliliter;
    }

}
