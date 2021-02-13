package models;

import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.ExceptionController;

public class User {
    private TreeMap<String, Chat> chats;
    private TreeMap<String, Notify> notify;
    private String userId;

    public User(String userId) {
        this.userId = userId;
        this.notify = new TreeMap<String, Notify>();
        this.chats = new TreeMap<String, Chat>();
    }

    public TreeMap<String, Chat> getChats() {
        return this.chats;
    }

    public ArrayList<Notify> getNotify() {
        return new ArrayList<Notify>(this.notify.values());
    }

    public Notify getNotifyChat(String chatId) throws ExceptionController {

        if(!this.notify.containsKey(chatId))
            throw new ExceptionController(this.userId + " is not in " + chatId + " chat", "ChatNotFound");

        return this.notify.get(chatId);
    }

    public void addChat(String chatId) throws ExceptionController{
        if(this.chats.containsKey(chatId))
            throw new ExceptionController(this.userId + " alrady exists in " + chatId + " chat", "ChatAlreadyExists");
        
        this.chats.put(chatId, new Chat(chatId));
        this.notify.put(chatId, new Notify(chatId));
    }

    public void addNotify(String chatId) throws ExceptionController {
        if(!this.notify.containsKey(chatId))
            throw new ExceptionController(this.userId + " is not in " + chatId + " chat", "ChatNotFound");
        
        this.notify.get(chatId).increment();
    }

    public void removeChat(String chatId) throws ExceptionController {
        if(!this.notify.containsKey(chatId))
            throw new ExceptionController(this.userId + " already is not in " + chatId + " chat", "ChatNotFound");
        
        this.chats.remove(chatId);
        this.notify.remove(chatId);
    }

    public String getUserId() {
        return this.userId;
    }
}
