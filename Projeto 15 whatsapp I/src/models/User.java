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

    public void addChat(Chat chat) throws ExceptionController{
        if(this.chats.containsKey(chat.getChatId()))
            throw new ExceptionController(this.userId + " alrady exists in " + chat.getChatId() + "chat", "ChatAlreadyExists");
        
        this.chats.put(chat.getChatId(), chat);
        this.notify.put(chat.getChatId(), new Notify(chat.getChatId()));
    }

    public void addNotify(String chatId) throws ExceptionController {
        if(!this.notify.containsKey(chatId))
            throw new ExceptionController(this.userId + " is not in " + chatId + " chat", "ChatNotFound");
        
        this.notify.get(chatId).increment();
    }

    public void removeChat(Chat chat) throws ExceptionController {
        if(!this.notify.containsKey(chat.getChatId()))
            throw new ExceptionController(this.userId + " already is not in " + chat.getChatId() + " chat", "ChatNotFound");
        
        this.chats.remove(chat.getChatId());
        this.notify.remove(chat.getChatId());
    }

    public String getUserId() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "[ " + this.userId + " ]";
    }
}
