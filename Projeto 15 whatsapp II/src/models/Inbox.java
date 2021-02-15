package models;

import java.util.ArrayList;

public class Inbox {
    private Chat chat;
    private User user;
    private ArrayList<Message> messages;
    private int unreadCount;

    public Inbox(Chat chat, User user) {
        this.chat = chat;
        this.user = user;
        this.messages = new ArrayList<Message>();
        this.unreadCount = 0;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
        this.unreadCount++;
    }

    public ArrayList<Message> getAllMessages() {
        return this.messages;
    }

    public ArrayList<Message> getUnreadMessages() {
        ArrayList<Message> messages = (ArrayList<Message>) this.messages
                .subList(this.messages.size() - this.unreadCount, this.messages.size());
        
        this.resetUnreadCount();
        return messages;
    }

    public int getUnreadCount() {
        this.resetUnreadCount();
        return this.unreadCount;
    }

    public void resetUnreadCount() {
        this.unreadCount = 0;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public String toString() {
        return "[ " + this.chat + (this.unreadCount > 0 ? "(" + this.unreadCount + ")" : "")+ " ]";
    }
}
