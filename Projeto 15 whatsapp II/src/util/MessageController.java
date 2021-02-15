package util;

import javax.swing.JOptionPane;

public class MessageController {
    
    public static String[] inputUser() {
        String[] line = JOptionPane.showInputDialog(null, 
                        "----------- Welcome to whatsapp ------------ \n" + 
                        "- CreateUser: {userId}\n" +
                        "- CreateGroup: {userId} {chatId}\n" +
                        "- CreateChat: {userId} {otherUserId} \n" +
                        "- Invite: {userGuess} {userInvited} {chatId}\n" +
                        "- SendMessage: {userId} {chatId} {message}\n" +
                        "- ReadChatMessage: {userId} {chatId}\n" +
                        "- ReadUnreadChatMessage: {userId} {chatId}\n" +
                        "- GetNotifyUser: {userId}\n" +
                        "- RemoveUser: {userId} {chatId}\n" +
                        "- End"
                        , "Whatsapp", 1).split(" ");
        return line;
    }

    public static void showMessage(String message, String title, boolean success) {
        JOptionPane.showMessageDialog(null, message, title, (success ? 1 : 0));
    }
}
