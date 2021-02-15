package models;

import exceptions.ExceptionController;

public class Talk extends Chat implements InterfaceAnyChat{
    
    public Talk(User user1, User user2) throws ExceptionController {
        super(
            (user1.getUserId().compareTo(user2.getUserId()) == -1) ? user1.getUserId() + "-" + user2.getUserId() : user1.getUserId() + "-" + user1.getUserId()
        );

        this.addUserChat(user1);
        this.addUserChat(user2);
    }

    private void addUserChat(User user) throws ExceptionController {
        this.inboxes.put(user.getUserId(), new Inbox(this, user));
        user.getchats().put(this.chatId, this);
    }

    @Override
    public void addUser(User user) throws ExceptionController {
        throw new ExceptionController("Append chat operation not supported", "AppendUserPrivateChat");
    }

    @Override
    public void remUser(User user) throws ExceptionController {
       throw new ExceptionController("Leave chat operation not supported", "LeaveUserPrivateChat");
    }
}
