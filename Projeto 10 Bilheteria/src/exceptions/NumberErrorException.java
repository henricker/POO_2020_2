package exceptions;

public class NumberErrorException extends Exception {
    private static final long serialVersionUID = 1L;

    public NumberErrorException(String msg) {
        super(msg);
    }
}
