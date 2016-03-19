package exception;

public class NonCompatibleTypeComparisonException extends Throwable{

    public NonCompatibleTypeComparisonException() {
        super("Units are not same");
    }
}
