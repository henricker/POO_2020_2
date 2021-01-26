import models.Moneylender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class App {

    public static void showMessage(String message) {
        Pattern pattern = Pattern.compile("Sucess message");
        Matcher matcher = pattern.matcher(message);

        if(matcher.find())
            JOptionPane.showMessageDialog(null, message, "Sucess message", 1);
        else
            JOptionPane.showMessageDialog(null, message, "Error message", 0);
    }

    public static void main(String[] args) throws Exception {
        Moneylender agiota = null;
        while(true) {
            String[] line = JOptionPane.showInputDialog(null, 
                                "Choose an option: \n" + 
                                " - init {money_initial} {percent_interest}\n" +
                                " - addCli {name} {limit} \n" +
                                " - lend {name} {value}\n" +
                                " - receive {name} {value}\n" +
                                " - kill {name}\n" +
                                " - show\n" +
                                " - end\n"
                            ).split(" ");
            
            if(line[0].equals("end"))
                break;
            
            else if(line[0].equals("init")) {
                try {
                    
                    agiota = new Moneylender(Double.parseDouble(line[1]), Double.parseDouble(line[2]));
                    JOptionPane.showMessageDialog(null, "Sucess message: agiota init with sucessfully!", "Sucess message", 1);
                
                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Error message: invalid number!", "Error message", 0);
                }catch(ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Just require values!", "Error message", 0);
                }
            }

            else if(line[0].equals("addCli")) {

                if(agiota == null) {
                    JOptionPane.showMessageDialog(null, "Error message: agiota dont initialized!", "Error message", 0);
                    continue;
                }

                try {
                    
                    String message = agiota.addCli(line[1], Double.parseDouble(line[2]));
                    showMessage(message);

                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Invalid number!", "Error message", 0);
                }catch(ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Just require values!", "Error message", 0);
                }
            }

            else if(line[0].equals("lend")) {
                
                if(agiota == null) {
                    JOptionPane.showMessageDialog(null, "Error message: agiota dont initialized!", "Error message", 0);
                    continue;
                }

                try {
                    
                    String message = agiota.lend(line[1], Double.parseDouble(line[2]));
                    showMessage(message);

                }catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Invalid number!", "Error message", 0);
                }catch(ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Just require values!", "Error message", 0);
                }

            }
            
            else if(line[0].equals("receive")) {

                if(agiota == null) {
                    JOptionPane.showMessageDialog(null, "Error message: agiota dont initialized!", "Error message", 0);
                    continue;
                }

                try {

                    String message = agiota.receive(line[1], Double.parseDouble(line[2]));
                    showMessage(message);

                }catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Invalid number!", "Error message", 0);
                }catch(ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Just require values!", "Error message", 0);
                }
            }
            
            else if(line[0].equals("kill")) {
                if(agiota == null) {
                    JOptionPane.showMessageDialog(null, "Error message: agiota dont initialized!", "Error message", 0);
                    continue;
                }

                try {
                    
                    String message = agiota.kill(line[1]);
                    showMessage(message);

                }catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Invalid number!", "Error message", 0);
                }catch(ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(null, "Error message: Please, just required values!", "Error message", 0);
                }
            }
            
            else if(line[0].equals("show")) {
                if(agiota == null) {
                    JOptionPane.showMessageDialog(null, "Error message: agiota dont initialized!", "Error message", 0);
                    continue;
                }

                String data = agiota.clientsInfo();
                data += agiota.transactionInfo();
                
                JOptionPane.showMessageDialog(null, data, "Info", 1);
            }
        }
    }
}
