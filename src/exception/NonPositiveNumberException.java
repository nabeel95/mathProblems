package exception;

public class NonPositiveNumberException extends  Throwable{
    public NonPositiveNumberException() {
       super("Expected positive number but received, non positive numbers");
    }
}
