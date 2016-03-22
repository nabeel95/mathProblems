package KingdomOfBallario;

import exception.BagRuleException;

import java.util.*;

public class Bag {
    private final static int bagCapacity = 12;
    private final static int maxNumberOfGreenBalls = 3;

    private Map<Colour, ArrayList<Ball>> balls;

    public Bag() {
        balls = new HashMap<Colour, ArrayList<Ball>>();
    }

    public int addBall(Ball ball) throws BagRuleException {
        if (totalBallsInBag() == bagCapacity)
            throw new BagRuleException("Bag is full");
        if (ball.isOfColour(Colour.GREEN))
            addGreenBall(ball);
        if (ball.isOfColour(Colour.RED))
            addRedBall(ball);
        if (ball.isOfColour(Colour.BLUE))
            addBlueBall(ball);
        if (ball.isOfColour(Colour.YELLOW))
            addYellowBall(ball);
        return totalBallsInBag();
    }

    private void addBlueBall(Ball ball) {
        ArrayList<Ball> blueBallList = getListOfColour(Colour.BLUE);
        blueBallList.add(ball);
    }

    private void addGreenBall(Ball ball) {
        if (numberOfBallsOfColour(Colour.GREEN) == maxNumberOfGreenBalls)
            throw new BagRuleException("Bag rule doesn't allow 3 < green balls");
        ArrayList<Ball> greenBalls = getListOfColour(Colour.GREEN);
        greenBalls.add(ball);
    }


    private boolean canBagAddRedBall() {
        return ((numberOfBallsOfColour(Colour.GREEN) * 2) - 1) > numberOfBallsOfColour(Colour.RED);
    }

    private void addRedBall(Ball ball) {
        if (!canBagAddRedBall())
            throw new BagRuleException("Bag rule doesn't allow more or equal to double of green");
        ArrayList<Ball> redBalls = getListOfColour(Colour.RED);
        redBalls.add(ball);
    }
    private void addYellowBall(Ball ball) {
        if (!canBagAddYellowBall())
            throw new BagRuleException("Bag rule doesn't allow more than 40% of yellow balls of total balls");
        ArrayList<Ball> yellowBalls = getListOfColour(Colour.YELLOW);
        yellowBalls.add(ball);
    }

    private boolean canBagAddYellowBall() {
        int total = totalBallsInBag();
        int yellowBalls = numberOfBallsOfColour(Colour.YELLOW);
        int percentageOfYellowBalls = (total * 40) / 100;
        return (yellowBalls + 1 ) <= percentageOfYellowBalls;
    }

    private ArrayList<Ball> getListOfColour(Colour colour) {
        ArrayList<Ball> a = balls.get(colour);
        if (a == null) {
            a = new ArrayList<Ball>();
            balls.put(colour, a);
        }
        return a;
    }

    private int totalBallsInBag() {
        return (numberOfBallsOfColour(Colour.BLUE) + numberOfBallsOfColour(Colour.GREEN) + numberOfBallsOfColour(Colour.RED) + numberOfBallsOfColour(Colour.YELLOW));
    }

    private int numberOfBallsOfColour(Colour color) {
        ArrayList<Ball> a = balls.get(color);
        if (a == null)
            return 0;
        return a.size();
    }

    public String showSummary() {
        return "Balls : "+totalBallsInBag()+"\nGreen : "+numberOfBallsOfColour(Colour.GREEN) +"\nRed : "+numberOfBallsOfColour(Colour.RED)+"\nYellow : "
                +numberOfBallsOfColour(Colour.YELLOW)+"\nBlue : "+numberOfBallsOfColour(Colour.BLUE);
    }
}
