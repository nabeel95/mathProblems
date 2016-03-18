package probability;

import exception.InvalidProbabilityException;


public class Chance {

    private double chance;

    private Chance(double value) {
        this.chance = value;
    }

    public static Chance createChance(double value) throws InvalidProbabilityException {
        if (value < 0 || value > 1)
            throw new InvalidProbabilityException();
        return new Chance(value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Chance chance = (Chance) other;
        return Double.compare(chance.chance, this.chance) == 0;

    }

    public Chance subtract(int value) throws InvalidProbabilityException {
        return createChance(value - this.chance);
    }

    public Chance add(Chance otherChance) throws InvalidProbabilityException {
        return createChance(this.chance * otherChance.chance);
    }

}

