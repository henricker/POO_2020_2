package exceptions;

public class SectorNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public SectorNotFound(String msg) {
        super(msg);
    }
}
