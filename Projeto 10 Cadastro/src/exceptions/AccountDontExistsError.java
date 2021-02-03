package exceptions;

public class AccountDontExistsError extends Exception {
     /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AccountDontExistsError(String msg) {
        super(msg);
    }

    
    public AccountDontExistsError(String msg, Throwable cause){
        super(msg, cause);
    }
}
