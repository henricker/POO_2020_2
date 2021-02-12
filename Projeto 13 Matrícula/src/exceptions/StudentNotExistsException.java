package exceptions;

public class StudentNotExistsException extends Exception{
    private static final long serialVersionUID = 1L;

    public StudentNotExistsException(String msg) {
        super(msg);
    }

    
    public StudentNotExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
