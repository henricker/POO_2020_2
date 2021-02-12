package exceptions;

public class EventAlreadyExists extends Exception {
    private static final long serialVersionUID = 1L;

    public EventAlreadyExists (String msg) {
        super(msg);
    }
}
