package exceptions;

public class UserAlredyExistsException extends Exception{
    private static final long serialVersionUID = 1L;

    public UserAlredyExistsException(String msg) {
        super(msg);
    }

    
    public UserAlredyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
