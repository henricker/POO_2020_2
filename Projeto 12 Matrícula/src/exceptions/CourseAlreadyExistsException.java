package exceptions;

public class CourseAlreadyExistsException extends Exception{
    private static final long serialVersionUID = 1L;

    public CourseAlreadyExistsException(String msg) {
        super(msg);
    }

    
    public CourseAlreadyExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
