

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import exceptions.AccountDontExistsError;
import exceptions.InvalidValueError;
import exceptions.NameIsNotStringError;
import models.AccountController;

public class App {

    public static void showMessage(String message, boolean sucess) {
        if(sucess) {
            JOptionPane.showMessageDialog(null, message, "Sucess message", 1);
        }else {
            JOptionPane.showMessageDialog(null, message, "Error message", 0);
        }
    }

    public static void main(String[] args) throws Exception {
        AccountController bank = new AccountController();

        while(true) {
            String[] line = JOptionPane.showInputDialog(
                                        "----- Riquinho's Bank -----\n" +
                                        "- addCli {name}\n" +
                                        "- deposit {id_account} {value}\n" +
                                        "- withdraw {id_account} {value}\n" +
                                        "- transfer {from_id} {to_id} {value}\n" +
                                        "- update\n" +
                                        "- show\n" +
                                        "- end"
                                        ).split(" ");
            
            if(line[0].equals("end"))
                break;
            
            else if(line[0].equals("addCli")) {
                try {
                    bank.AddCli(line[1]);
                    App.showMessage("Client created with success!", true);
                }catch (ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Many arguments passed!", false);
                }catch(NameIsNotStringError err) {
                    App.showMessage(err.getMessage(), false);
                }
            }
           
            else if(line[0].equals("deposit")) {
                if(bank.getSizeAccounts() == 0)
                    App.showMessage("Dont exists account in system!", false);
                else {
                    try {
                        bank.deposit(Integer.parseInt(line[1]), Float.parseFloat(line[2]));
                        App.showMessage("Deposit successful!", true);
                    }catch(InvalidValueError err) {
                        App.showMessage(err.getMessage(), false);
                    }catch(ArrayIndexOutOfBoundsException err) {
                        App.showMessage("Many arguments passed!", false);
                    }catch(NumberFormatException err) {
                        App.showMessage("Values non-numerics passed!", false);
                    }
                }
            }

            else if(line[0].equals("transfer")){
                if(bank.getSizeAccounts() == 0)
                    App.showMessage("Dont exists account in system!", false);
                else { 
                    try {
                        bank.transfer(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Float.parseFloat(line[3]));
                        App.showMessage("Transfer successful!", true);
                    }catch(InvalidValueError err) {
                        App.showMessage(err.getMessage(), false);
                    }catch(ArrayIndexOutOfBoundsException err) {
                        App.showMessage("Many arguments passed!", false);
                    }catch(NumberFormatException err) {
                        App.showMessage("Values non-numerics passed!", false);
                    }catch(AccountDontExistsError err) {
                        App.showMessage(err.getMessage(), false);
                    }
                }
            }

            else if(line[0].equals("withdraw")) {
                if(bank.getSizeAccounts() == 0)
                    App.showMessage("Dont exists account in system!", false);
                else { 
                    try {
                        bank.withdraw(Integer.parseInt(line[1]), Float.parseFloat(line[2]));
                        App.showMessage("Withdraw successful!", true);
                    }catch(InvalidValueError err) {
                        App.showMessage(err.getMessage(), false);
                    }catch(ArrayIndexOutOfBoundsException err) {
                        App.showMessage("Many arguments passed!", false);
                    }catch(NumberFormatException err) {
                        App.showMessage("Values non-numerics passed!", false);
                    }
                }
            }
            
            else if(line[0].equals("update")) {
                bank.update();
                App.showMessage("Updated successful!", true);
            }
            
            else if(line[0].equals("show")) {
                App.showMessage(bank.show(), true);
            }
        }
    }
}
