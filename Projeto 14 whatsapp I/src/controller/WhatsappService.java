package controller;

import java.util.TreeMap;

//Exception
import exceptions.ExceptionController;

//models
import models.Chat;
import models.User;

public class WhatsappService {
    private TreeMap<String, User> users;
    private TreeMap<String, Chat> chats;

    public WhatsappService() {
        users = new TreeMap<String, User>();
        chats = new TreeMap<String, Chat>();
    }

    private User getUser(String userId) throws ExceptionController {
        if(!this.users.containsKey(userId))
            throw new ExceptionController(userId + " not exists!", "UserNotFound");
        
        return this.users.get(userId);
    }

    private Chat getChat(String chatId) throws ExceptionController {
        if(!this.chats.containsKey(chatId))
            throw new ExceptionController(chatId + " not exists!", "ChatNotFound");
        
        return this.chats.get(chatId);
    }

    public boolean chatExists(String chatId) {
        return this.chats.containsKey(chatId);
    }

    public boolean userExists(String userId) {
        return this.users.containsKey(userId);
    }

    public String getChatsUser(String userId) throws ExceptionController{
        User user = this.getUser(userId);
        
        StringBuilder sb = new StringBuilder();
        sb.append(userId + " [chats]:\n");
        user.getChats().values().forEach((chat) -> {
            sb.append("    - " + chat.getChatId() + "\n");
        });

        return sb.toString();
    }

    public String getUsersChat(String chatId) throws ExceptionController{
        Chat chat = this.getChat(chatId);

        StringBuilder sb = new StringBuilder();
        sb.append(chatId + " [users]:\n");
        chat.getUsers().values().forEach(user -> {
            sb.append("    - " + user.getUserId() + "\n");
        });

        return sb.toString();
    }

    public String getNotifyUser(String userId) throws ExceptionController {
        User user = this.getUser(userId);

        StringBuilder sb = new StringBuilder();
        sb.append(userId + " [notify]:\n");
        user.getNotify().forEach(notify -> {
            sb.append("    - " + notify + "\n");
        });

        return sb.toString();
    }

    public void createUser(String userId) throws ExceptionController {
        if(this.userExists(userId))
            throw new ExceptionController(userId + " already exists", "UserAlreadyExists");
        
        this.users.put(userId, new User(userId));
    }

    public void createChat(String userId, String chatId) throws ExceptionController {
        User user = this.getUser(userId);

        if(this.chatExists(chatId))
            throw new ExceptionController(chatId + " already exists", "ChatAlreadyExists");

        Chat newChat = new Chat(chatId);
        this.chats.put(chatId, newChat);
        user.addChat(newChat);
        newChat.addUser(user);
    }

    public void addByInvite(String userId, String invited, String chatId) throws ExceptionController {
        User user = this.getUser(userId);
        User newUser = this.getUser(invited);
        Chat chat = this.getChat(chatId);

        if(!user.getChats().containsKey(chatId))
            throw new ExceptionController(userId + " not in " + chatId, "InvitedException");
        
        if(newUser.getChats().containsKey(chatId))
            throw new ExceptionController(invited + " already in " + chatId, "InvitedException");
        
        chat.addByInvite(user, newUser);
        newUser.addChat(chat);
    }

    public String getAllUser() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("All users:\n");
        this.users.values().forEach(user ->  {
            sb.append("    - " + user + "\n");
        });

        return sb.toString();
    }

    public void removeUser(String userId, String chatId) throws ExceptionController {
        User user =  this.getUser(userId);
        Chat chat = this.getChat(chatId);

        if(!user.getChats().containsKey(chatId))
            throw new ExceptionController(userId + " already not in " + chatId, "UserAlreadyNotInChat");

        user.removeChat(chat);
        chat.removeUserChat(user);
    }

    public void sendMessage(String userId, String chatId, String message) throws ExceptionController {
        User user = this.getUser(userId);
        Chat chat = this.getChat(chatId);

        chat.deliverZap(user, message);
    }

    public String readMessage(String userId, String chatId) throws ExceptionController {
        User user = this.getUser(userId);
        Chat chat = this.getChat(chatId);

        if(!user.getChats().containsKey(chatId))
            throw new ExceptionController(userId + " not in " + chatId,"UserNotFound");

        StringBuilder sb = new StringBuilder();
        sb.append(userId + " - [" + chatId + "]:\n");
        chat.getInboxUser(user).getMessages().forEach(message -> {
            sb.append("    - " + message + "\n");
        });
        
        user.getNotifyChat(chatId).restarCounter();
        return sb.toString();
    }

}
