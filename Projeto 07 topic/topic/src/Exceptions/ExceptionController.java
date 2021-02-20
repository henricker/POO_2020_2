package Exceptions;

public class ExceptionController extends Exception {
    private String title;
    public ExceptionController(String title, String message) {
        super(message);
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
