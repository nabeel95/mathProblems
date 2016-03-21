package KingdomOfBallario;

import javax.swing.plaf.ColorUIResource;

public class Ball {


    private final Colour colour;

    public Ball(Colour colour) {
        this.colour = colour;
    }

     public boolean isOfColour(Colour colour){
         return this.colour == colour;
     }

}
