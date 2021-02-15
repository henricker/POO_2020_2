package models;

public class Message {
    private String userId;
    private String message;

    public Message(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    @Override
    public String toString() {
        return this.userId + ": " + this.message;
    }
}
