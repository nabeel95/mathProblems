package measurement;

public class Feet implements Unit{
    private double value;

    public Feet(double value) {
        this.value = value;
    }
    @Override
    public double convertIntoMiliMeter() {
        return this.value * 12 * 25.4;
    }

    @Override
    public boolean equals(Unit unit) {
        return unit.convertIntoMiliMeter() == convertIntoMiliMeter();
    }

}
