package src.util;

import javax.swing.JOptionPane;

public class IOController {
  
  public static String[] IO() {
    String line[] = JOptionPane
                    .showInputDialog(null,
                    "-------------- Hospital -------------\n" +
                    "AddPatient: {patient}-{diagnosys} ...\n" +
                    "AddDoctor: {doctor}-{specialty} ... \n" +
                    "Tie: {patient} {doctor}\n" +
                    "SendMessage: {sender} {receiver} {message}\n" +
                    "Inbox: {patient or doctor}\n" +
                    "Show\n" +
                    "End"
                    )
                    .split(" ");
   
    return line;
  }


  public static void showMessage(String message, String title, boolean success) {
    if(success)
      JOptionPane.showMessageDialog(null, message, title, 1);
    else
      JOptionPane.showMessageDialog(null, message, title, 0);
  }
}
