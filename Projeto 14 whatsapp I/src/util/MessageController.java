package util;

import javax.swing.JOptionPane;

public class MessageController {

    public static String[] inputUser() {
        String[] line = JOptionPane.showInputDialog(null, 
                        "----------- Welcome to whatsapp ------------ \n" + 
                        "- CreateUser: {userId}\n" +
                        "- CreateChat: {userId} {chatId}\n" +
                        "- Invite: {userGuess} {userInvited} {chatId}\n" +
                        "- SendMessage: {userId} {chatId} {message}\n" +
                        "- ReadMessage: {userId} {chatId}\n" +
                        "- GetNotifyUser: {userId}\n" +
                        "- GetChatsByUser: {userId}\n" +
                        "- GetUsersByChat: {chatId}\n" +
                        "- RemoveUser: {userId} {chatId}\n" +
                        "- GetAllUsers\n" +
                        "- GetAllChats\n" +
                        "- End"
                        , "Whatsapp", 1).split(" ");
        return line;
    }

    public static void showMessage(String message, String title, boolean success) {
        JOptionPane.showMessageDialog(null, message, title, (success ? 1 : 0));
    }
}
