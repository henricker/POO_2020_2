package exceptions;

public class CourseNotExistsException extends Exception{
    private static final long serialVersionUID = 1L;

    public CourseNotExistsException(String msg) {
        super(msg);
    }

    
    public CourseNotExistsException(String msg, Throwable cause){
        super(msg, cause);
    }
}
