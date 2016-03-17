/*
Job of class Rectangle-
    * to calculate the possible attributes/quantities of a rectangle.
 */

public class Rectangle {

    private final double height;
    private final double width;

    private Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }


    public double calculateArea() {
        return height * width;
    }

    public double calculatePerimeter(){
        return 2*(height + width);
    }

    public static Rectangle createRectangle(double height,double width){
        if((width<0) || (height<0))
            throw new IllegalArgumentException("invalid height or width..");
        return new Rectangle(height,width);
    }
}
