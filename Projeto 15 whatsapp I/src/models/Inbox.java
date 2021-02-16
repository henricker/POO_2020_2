package models;

import java.util.ArrayList;

public class Inbox {
    private User user;
    private ArrayList<Message> messages;

    Inbox(User user) {
        this.user = user;
        this.messages = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public User getUser() {
        return this.user;
    }
}
