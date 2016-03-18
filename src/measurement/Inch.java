package measurement;

public class Inch implements Unit{
    private final double value;
    public Inch(double value) {
        this.value = value;
    }
    @Override
    public double convertIntoMiliMeter () {
        return this.value * 25.4;
    }

    @Override
    public boolean equals(Unit unit) {
        return unit.convertIntoMiliMeter() == convertIntoMiliMeter();
    }
}
