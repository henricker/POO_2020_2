package exceptions;

public class SectorAlreadyExists extends Exception {
    private static final long serialVersionUID = 1L;

    public SectorAlreadyExists(String msg) {
        super(msg);
    }
}
