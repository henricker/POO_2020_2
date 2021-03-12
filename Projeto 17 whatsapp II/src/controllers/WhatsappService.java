package controllers;

import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.ExceptionController;
import models.Chat;
import models.Group;
import models.Message;
import models.Talk;
import models.User;

public class WhatsappService {
    private TreeMap<String, Chat> chatsRepository;
    private TreeMap<String, User> usersRepository;

    public WhatsappService() {
        this.chatsRepository = new TreeMap<String, Chat>();
        this.usersRepository = new TreeMap<String, User>();
    }

    public void createUser(String userId) throws ExceptionController {
        if(this.hasUser(userId))
            throw new ExceptionController(userId + " already exists!", "UserAlreadyExists");
        
        this.usersRepository.put(userId, new User(userId));
    }

    public void createGroup(String userId, String chatId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User not exists!", "UserNotFound");
        
        if(this.hasChat(chatId))
            throw new ExceptionController("Group already exists!", "GroupAlreadyExists");
        
        Group group = new Group(chatId);
        group.addUser(this.usersRepository.get(userId));
        this.chatsRepository.put(chatId, group);
        this.usersRepository.get(userId).getchats().put(chatId, group);
    }

    public void createChat(String userId, String invited) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        if(!this.hasUser(invited))
            throw new ExceptionController("User " + invited + " not exists!", "UserNotFound");
        if(this.hasChat(userId + "-" + invited) || this.hasChat(invited + "-" + userId))
            throw new ExceptionController("Chat already exists!", "ChatAlreadyExists");
        if(userId.equals(invited))
            throw new ExceptionController("Not accept intited yourself!", "InvitedYourSelf");
        
        User userGuess = this.usersRepository.get(userId);
        User userInvited = this.usersRepository.get(invited);

        Talk talk = new Talk(userGuess, userInvited);
        userGuess.getchats().put(talk.getChatId(), talk);
        userInvited.getchats().put(talk.getChatId(), talk);
        this.chatsRepository.put(talk.getChatId(), talk);
    }

    public void invite(String userId, String invited, String groupId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        if(!this.hasUser(invited))
            throw new ExceptionController("User " + invited + " not exists!", "UserNotFound");
        if(!(this.hasChat(groupId)))
            throw new ExceptionController("Group " + groupId + " not exists!", "GroupNotFound");
        if(!(this.usersRepository.get(userId).getchats().containsKey(groupId)))
            throw new ExceptionController("User " + userId + " not exists in " + groupId, "UserNotFound");
        if(this.usersRepository.get(invited).getchats().containsKey(groupId))
            throw new ExceptionController("User " + invited + " already exists in " + groupId, "UserNotFound");
        
        User userInvited = this.usersRepository.get(invited);
        
        if(this.chatsRepository.get(groupId) instanceof Talk){
            Talk talk = (Talk)this.chatsRepository.get(groupId);
            talk.addUser(userInvited);
        }

        Group group = (Group) this.chatsRepository.get(groupId);
        
        userInvited.getchats().put(group.getChatId(), group);
        group.addUser(userInvited);
    }

    public void removeUserChat(String userId, String chatId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        if(!this.hasChat(chatId))
            throw new ExceptionController("Chat " + chatId + " not exists!", "ChatNotFound");
        if(!(this.usersRepository.get(userId).getchats().containsKey(chatId)))
            throw new ExceptionController("User " + userId + " not exists in " + chatId, "UserNotFound");
        
        Chat chat = this.chatsRepository.get(chatId);
        if(chat instanceof Talk) {
            Talk talk = (Talk) chat;
            talk.remUser(this.usersRepository.get(userId));
        }

        Group group = (Group) chat;
        group.remUser(this.usersRepository.get(userId));

    }

    public String getChatsUser(String userId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        
        return this.usersRepository.get(userId).getChatsString();
    }

    public String getNofityUser(String userId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        
        return this.usersRepository.get(userId).getNotify();
    }

    public String getUnreadChatMessage(String userId, String chatId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        if(!this.hasChat(chatId))
            throw new ExceptionController("Chat " + chatId + " not exists!", "ChatNotFound");
        

        ArrayList<Message> messages = this.chatsRepository.get(chatId).getMessages(userId, true);
        StringBuilder sb = new StringBuilder();
        messages.forEach(message -> {
            sb.append("    - " + message + "\n");
        });

        return sb.toString();
    }

    public String getChatMessage(String userId, String chatId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        if(!this.hasChat(chatId))
            throw new ExceptionController("Chat " + chatId + " not exists!", "ChatNotFound");
        

        ArrayList<Message> messages = this.chatsRepository.get(chatId).getMessages(userId, false);
        StringBuilder sb = new StringBuilder();
        messages.forEach(message -> {
            sb.append("    - " + message + "\n");
        });

        return sb.toString();
    }

    public void sendMessage(String userId, String chatId, String message) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        if(!this.hasChat(chatId))
            throw new ExceptionController("Chat " + chatId + " not exists!", "ChatNotFound");
        
        this.chatsRepository.get(chatId).deliverZap(userId, message);
    }

    public String getNotifyUser(String userId) throws ExceptionController {
        if(!this.hasUser(userId))
            throw new ExceptionController("User " + userId + " not exists!", "UserNotFound");
        
        return this.usersRepository.get(userId).getNotify();
    }

    public TreeMap<String, Chat> getChats() {
        return this.chatsRepository;
    }

    private boolean hasUser(String userId) {
        return this.usersRepository.containsKey(userId);
    }

    private boolean hasChat(String groupId) {
        return this.chatsRepository.containsKey(groupId);
    }
}
