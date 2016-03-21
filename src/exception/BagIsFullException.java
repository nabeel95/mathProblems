package exception;

public class BagIsFullException extends RuntimeException {

    public BagIsFullException(String message) {
        super(message);
    }
}
