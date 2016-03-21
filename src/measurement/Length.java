package measurement;

public enum Length implements Unit {

    feet(12 * 25.4) ,
    inch(25.4),
    centimeter(10),
    millimeter(1) ;

    private double baseFactor;

    Length(double baseFactor) {
        this.baseFactor = baseFactor;
    }

    @Override
    public double baseFactor() {
        return baseFactor;
    }

    @Override
    public Unit baseUnit() {
        return Length.millimeter;
    }

}
