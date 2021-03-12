package error;

public class Error extends Exception {

  private static final long serialVersionUID = 1L;
  private String type;

  public Error(String message, String type) {
    super(message);
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}