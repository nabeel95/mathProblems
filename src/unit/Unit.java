package unit;
import exception.NonCompatibleTypeComparisonException;
public interface Unit {
    public double convertIntoBaseUnit();
    public boolean isEqualTo(Unit unit) throws NonCompatibleTypeComparisonException;
}
