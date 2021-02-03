package exceptions;

public class InvalidValueError extends Exception {
     /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidValueError(String msg) {
        super(msg);
    }

    
    public InvalidValueError(String msg, Throwable cause){
        super(msg, cause);
    }
}
