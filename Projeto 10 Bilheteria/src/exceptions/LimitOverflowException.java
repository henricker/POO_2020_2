package exceptions;

public class LimitOverflowException extends Exception {
    private static final long serialVersionUID = 1L;

    public LimitOverflowException(String msg) {
        super(msg);
    }
}