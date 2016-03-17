package rectangle;/*
Job of class rectangle-
    * to calculate the possible attributes/quantities of a rectangle.
 */

import exception.NonPositiveNumberException;

public class Rectangle {

    private final double height;
    private final double width;

    protected Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }


    public double calculateArea() {
        return height * width;
    }

    public double calculatePerimeter() {
        return 2 * (height + width);
    }

    public static Rectangle create(double height, double width) throws NonPositiveNumberException {
        if (height <= 0 || width <= 0)
            throw new NonPositiveNumberException();
        return new Rectangle(height, width);
    }
}
