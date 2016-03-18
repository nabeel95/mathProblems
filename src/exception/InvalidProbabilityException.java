package exception;

public class InvalidProbabilityException extends Throwable {

    public InvalidProbabilityException() {
        super("Invalid Probability. expected 0><1 ");
    }
}
