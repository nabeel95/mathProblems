package KingdomOfBallario;

import exception.BagIsFullException;

import java.util.*;

public class Bag {

    private Map<Colour, ArrayList<Ball>> balls;
    public Bag() {
        balls = new HashMap<Colour,ArrayList<Ball> >();
    }

    public int addBall(Ball ball) throws BagIsFullException{
        if ( sizeOfBag() == 12)
            throw  new BagIsFullException("Bag is full");
        if(ball.isOfColour(Colour.GREEN))
            addGreenBall(ball);
        if(ball.isOfColour(Colour.RED))
            addRedBall(ball);
        if (ball.isOfColour(Colour.BLUE))
            addBlueBall(ball);
        return sizeOfBag();
    }

    private void addBlueBall(Ball ball) {
        ArrayList<Ball> blueBallList = getListOf(Colour.BLUE);
        blueBallList.add(ball);
    }

    private void addGreenBall(Ball ball) {
        if (numberOfBalls(Colour.GREEN) == 3)
            throw new BagIsFullException("Bag rule doesn't allow 3 < green balls");
        ArrayList<Ball> greenBalls = getListOf(Colour.GREEN);
        greenBalls.add(ball);
    }

    private ArrayList<Ball> getListOf(Colour colour) {
        ArrayList<Ball> a = (ArrayList<Ball>) balls.get(colour);
        if (a == null){
            a = new ArrayList<Ball>();
            balls.put(colour, a);
        }
        return a;
    }
    private void addRedBall(Ball ball) {
        if (((numberOfBalls(Colour.GREEN) * 2)-1) <= numberOfBalls(Colour.RED))
            throw new BagIsFullException("Bag rule doesn't allow more or equal to double of green");
        ArrayList<Ball> redBalls = getListOf(Colour.RED);
        redBalls.add(ball);
    }
    public int sizeOfBag(){
        int size=0;
        Set set = balls.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            ArrayList list  = (ArrayList) me.getValue();
            size+=list.size();
        }
        return size;
    }

    private int numberOfBalls(Colour color){
        ArrayList<Ball> a = (ArrayList<Ball>) balls.get(color);
        if(a == null)
            return 0;
        return a.size();
    }

}
