package measurement;

import exception.IncompatibleTypeException;

public class Measurement {
    private double value;
    private Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private Measurement convertToBase() {
        double value = this.value * this.unit.baseFactor();
        Unit unit = this.unit.baseUnit();
        return new Measurement(value, unit);
    }

    private boolean isOfSameType(Measurement measurement) {
        return (measurement == null || unit.getClass() == measurement.unit.getClass());
    }

    public Measurement addInto(Measurement measurement) throws IncompatibleTypeException {
        if (!isOfSameType(measurement))
            throw new IncompatibleTypeException();
        Measurement measurementToAdd = measurement.convertToBase();
        Measurement self = convertToBase();
        double sum = (self.value + measurementToAdd.value);
        return new Measurement(sum, unit.baseUnit());
    }

    public boolean isEqual(Measurement measurement) throws IncompatibleTypeException {
        if (!isOfSameType(measurement))
            throw new IncompatibleTypeException();
        return equals(measurement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement self = this.convertToBase();
        Measurement another = ((Measurement) o).convertToBase();

        return Double.compare(self.value, another.value) == 0;
    }
}
