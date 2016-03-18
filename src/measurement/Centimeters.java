package measurement;

public class Centimeters implements Unit {

    private double value;

    public Centimeters(double value) {
        this.value = value;
    }

    @Override
    public double convertIntoMiliMeter() {
        return this.value * 10;
    }

    @Override
    public boolean equals(Unit unit) {
        return unit.convertIntoMiliMeter() == convertIntoMiliMeter();
    }
}
