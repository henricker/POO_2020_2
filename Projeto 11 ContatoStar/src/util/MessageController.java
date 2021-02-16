package util;

import javax.swing.JOptionPane;

public class MessageController {
    
    public static String[] inputUser() {
        String[] line = JOptionPane.showInputDialog(null, 
                        "----------- Phonebook ------------ \n" + 
                        "- AddContact: {contactId} \n" +
                        "- RemoveContact: {ContactId} \n" +
                        "- AddPhone: {contactId} {label:number} {label:number} ... \n" +
                        "- RemovePhone: {contactId} {indexPhone} \n" +
                        "- Search: {pattern}" +
                        "- ShowAllContacts\n" +
                        "- ShowBookMarks\n" + 
                        "- Star: {contactId} \n" +
                        "- Unstar: {contactId}\n" +
                        "- End"
                        , "Phonebook", 1).split(" ");
        return line;
    }

    public static void showMessage(String message, String title, boolean success) {
        JOptionPane.showMessageDialog(null, message, title, (success ? 1 : 0));
    }
}