package square;
/*
Job of class square-
       * to calculate the possible attributes/quantities of a square.
 */

import exception.NonPositiveNumberException;
import rectangle.Rectangle;

public class Square extends Rectangle {


    private Square(double side) {
        super(side, side);
    }

    public static Square create(double side) throws NonPositiveNumberException {
        if (side <= 0)
            throw new NonPositiveNumberException();
        return new Square(side);
    }

}
