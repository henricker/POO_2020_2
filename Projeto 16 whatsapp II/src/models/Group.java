package models;

import exceptions.ExceptionController;

public class Group extends Chat implements InterfaceAnyChat {

    public Group(String chatId) {
        super(chatId);
    }

    @Override
    public void addUser(User user) {
        this.inboxes.put(user.getUserId(), new Inbox(this, user));
        user.getchats().put(this.chatId, this);
    }

    @Override
    public void remUser(User user) throws ExceptionController {
        if(!this.hasUser(user.getUserId()))
            throw new ExceptionController(user.getUserId() + " does not in  " + this.chatId, "UserNotFound");
        
        this.inboxes.remove(user.getUserId());
        user.getchats().remove(this.chatId);
    }

    
}
