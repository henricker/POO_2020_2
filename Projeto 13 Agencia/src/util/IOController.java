package util;

import javax.swing.JOptionPane;

public class IOController {
  public static String[] IO() {
    String line[] = JOptionPane
                    .showInputDialog(null,
                    "--------- Riquinho's Bank --------\n" +
                    "- addCli {name}\n" +
                    "- deposit {id_account} {value}\n" +
                    "- withdraw {id_account} {value}\n" +
                    "- transfer {from_id} {to_id} {value}\n" +
                    "- update\n" +
                    "- show\n" +
                    "- end"
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
