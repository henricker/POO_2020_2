package models;

public class Notify {
    private String chatId;
    private int unreadCount;

    public Notify(String chatId) {
        this.chatId = chatId;
        this.unreadCount = 0;
    }

    public String getChatId() {
        return this.chatId;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public void increment() {
        this.unreadCount++;
    }

    public void restarCounter() {
        this.unreadCount = 0;
    }

    @Override
    public String toString() {
        return "[ " + this.chatId + "(" + this.unreadCount + ") ]";
    }
  
}
