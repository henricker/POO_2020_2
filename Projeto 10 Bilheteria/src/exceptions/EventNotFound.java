package exceptions;

public class EventNotFound extends Exception{
    private static final long serialVersionUID = 1L;

    public EventNotFound(String msg) {
        super(msg);
    }
}
