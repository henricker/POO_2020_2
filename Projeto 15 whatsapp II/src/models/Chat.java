package models;

import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.ExceptionController;

public abstract class Chat {
    protected String chatId;
    protected TreeMap<String, Inbox> inboxes;

    public Chat(String chatId) {
        this.chatId = chatId;
        this.inboxes = new TreeMap<String, Inbox>();
    }

    public ArrayList<Message> getMessages(String userId, boolean onlyUnread) throws ExceptionController{
        
        if(onlyUnread)
            return this.inboxes.get(userId).getUnreadMessages();
        return this.inboxes.get(userId).getAllMessages();
    }

    public String getInboxNotify(String userId) {
        return this.inboxes.get(userId).toString();
    }

    public boolean hasUser(String userId) {
        return this.inboxes.containsKey(userId);
    }

    public void deliverZap(String userId, String message) throws ExceptionController {     
        Message newMessage = new Message(userId, message);
        this.inboxes.values().forEach(inbox -> {
            if(!inbox.getUser().getUserId().equals(userId))
                inbox.addMessage(newMessage);
        });
    }

    public String getChatId() {
        return this.chatId;
    }

    @Override
    public String toString() {
        return this.chatId;
    }
}
