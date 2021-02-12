package util;

import javax.swing.JOptionPane;

public class MessageController {
    private String title;
    private String message;
    private boolean errorMessage;

    public void init(String title, String message, boolean errorMessage) {
        this.title = title;
        this.errorMessage = errorMessage;
        this.message = message;
    }

    public void showMessage() {
        JOptionPane.showMessageDialog(null, this.message, this.title, this.errorMessage ? 0 : 1);
    }

    public static String getInputUser() {
        String input = JOptionPane.showInputDialog(null, 
                "       --------- Ticket Office ----------    \n" + 
                "- AddClient: {nameClient} {half or full}\n" + 
                "- AddSector: {nameSector} {nameEvent} {price} {capacity}\n" + 
                "- AddEvent: {nameEvent}\n" + 
                "- Sale: {nameClient} {nameSector} {nameEvent}\n" +
                "- ShowClients\n" + 
                "- ShowEvents\n" + 
                "- ShowSales\n" +
                "- Logout\n"
            );
        
        return input;
    } 

}
