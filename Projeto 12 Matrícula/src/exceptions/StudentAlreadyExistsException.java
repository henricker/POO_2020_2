package exceptions;

public class StudentAlreadyExistsException extends Exception{
    private static final long serialVersionUID = 1L;

    public StudentAlreadyExistsException(String msg) {
        super(msg);
    }

    
    public StudentAlreadyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}

