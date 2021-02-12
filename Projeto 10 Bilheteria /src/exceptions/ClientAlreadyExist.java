package exceptions;

public class ClientAlreadyExist extends Exception {
    private static final long serialVersionUID = 1L;

    public ClientAlreadyExist  (String msg) {
        super(msg);
    }
}
