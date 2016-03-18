package exception;

public class InvalidProbabilityException extends Throwable {

    public InvalidProbabilityException() {
        super("Invalid Probability. expected numbers between 0 & 1");
    }
}
