package unit.length;

public interface Unit {
    public double convertIntoBaseUnitAsMm();
    public boolean isEqualTo(Unit unit);
    public Unit addWith(Unit unit);
}
