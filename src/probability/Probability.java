
package probability;

import exception.InvalidProbabilityException;

public class Probability {

    private final int favourable;
    private final int totalOutcome;

    private Probability(int favourable, int totalOutcome) {
        this.favourable = favourable;
        this.totalOutcome = totalOutcome;
    }

    public static Probability create(int favourable, int totalOutcome){
        return new Probability(favourable,totalOutcome);
    }

    public Chance getOccuringProbability() throws InvalidProbabilityException {
        double chances = (double) favourable / (double) totalOutcome;
        return Chance.createChance(chances);
    }

    public Chance getNotOccuringProbability() throws InvalidProbabilityException {
        Chance chances = getOccuringProbability();
        return chances.subtract(1);
    }

    public Chance getProbabilityOfGettingSameEvent() throws InvalidProbabilityException {
        Chance chanceOfEventOccurring = getOccuringProbability();
        return chanceOfEventOccurring.add(getOccuringProbability());
    }

    public Chance getProbabilityOfGettingAtLeastOneEvent() throws InvalidProbabilityException {
        Chance chanceOfGettingSameEvent = getProbabilityOfGettingSameEvent();
        return chanceOfGettingSameEvent.subtract(1);
    }

}