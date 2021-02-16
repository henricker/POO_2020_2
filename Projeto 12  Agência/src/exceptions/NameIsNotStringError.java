package exceptions;

public class NameIsNotStringError extends Exception{
     /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NameIsNotStringError(String msg) {
        super(msg);
    }

    
    public NameIsNotStringError(String msg, Throwable cause){
        super(msg, cause);
    }
}
