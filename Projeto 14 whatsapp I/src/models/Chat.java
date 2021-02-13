package models;

import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.ExceptionController;

public class Chat {
    private String chatId;
    private TreeMap<String, Inbox> inboxes;
    private TreeMap<String, User> users;

    public Chat(String chatId) {
        this.chatId = chatId;
        this.inboxes = new TreeMap<String, Inbox>();
        this.users = new TreeMap<String, User>();
    }

    public ArrayList<Message> getMessages(String userId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController(this.chatId + " not contains " + userId + " user", "UserNotFound");
        
        
        return this.inboxes.get(userId).getMessages();  
    }

    public TreeMap<String, User> getUsers() {
        return this.users;
    }

    public void deliverZap(User user, String message) throws ExceptionController {
        if(!this.hasUser(user.getUserId()))
            throw new ExceptionController(this.chatId + " not contains " + user.getUserId() + " user", "UserNotFound");
        
        Message newMessage = new Message(user.getUserId(), message);
        
        this.inboxes.values().forEach(inbox -> {
            if(!inbox.getUser().equals(user)) {
                inbox.addMessage(newMessage);
            }
        });

        for(User userIter : this.users.values()) {
            if(!userIter.equals(user)) {
                userIter.addNotify(this.chatId);
            }
        }
    }

    public Inbox getInboxUser(User user) throws ExceptionController {
        if(!this.hasUser(user.getUserId()))
            throw new ExceptionController(this.chatId + " not contains " + user.getUserId() + " user", "UserNotFound");
        
        return this.inboxes.get(user.getUserId());
    }

    public int getUnreadCount(String userId) throws ExceptionController {
        return this.users.get(userId).getNotifyChat(this.chatId).getUnreadCount();
    }

    public boolean hasUser(String userId) {
        return this.users.containsKey(userId);
    }

    public void addUser(User user) throws ExceptionController {
        if(this.hasUser(user.getUserId()))
            throw new ExceptionController(this.chatId + " already contains " + user.getUserId() + " user", "UserAlreadyExists");
        
        this.users.put(user.getUserId(), user);
        this.inboxes.put(user.getUserId(), new Inbox(user));
    }

    public void addByInvite(User user, User invited) throws ExceptionController {
        if(!this.hasUser(user.getUserId()))
            throw new ExceptionController(this.chatId + " not contains " + user.getUserId() + " user", "UserNotFound");
        
        if(this.hasUser(invited.getUserId()))
            throw new ExceptionController(this.chatId + " already contains " + invited.getUserId() + " user", "UserAlreadyExists");
        
        this.addUser(invited);
    }

    public void removeUserChat(User user) throws ExceptionController {
        if(!this.hasUser(user.getUserId()))
            throw new ExceptionController(this.chatId + " already not contains " + user.getUserId() + " user", "UserNotFound");
        
        this.users.remove(user.getUserId());
        this.inboxes.remove(user.getUserId());
    }

    public String getChatId() {
        return this.chatId;
    }

}
