package view;

import controller.Bank;
import util.IOController;

public class View {
  public static void run() {
    Bank bank = new Bank();

    while(true) {
      String[] line = IOController.IO();
      
      if(line[0].equals("end"))
          break;
      
      else if(line[0].equals("addCli")) {
        try {
          bank.addClient(line[1]);
          IOController.showMessage("Client created with success!", "Success", true);
        }catch (ArrayIndexOutOfBoundsException err) {
          IOController.showMessage("Many arguments passed!", "Fail", false);
        }catch(Exception err) {
          IOController.showMessage(err.getMessage(), "Fail", false);
        }
      }
      
      else if(line[0].equals("deposit")) {
        try {
          bank.deposit(Integer.parseInt(line[1]), Float.parseFloat(line[2]));
          IOController.showMessage("Deposit successful!", "Success", true);
        }catch(ArrayIndexOutOfBoundsException err) {
          IOController.showMessage("Many arguments passed!", "Fail", false);
        }catch(NumberFormatException err) {
          IOController.showMessage("Invalid value passed by argument","Fail", false);
        }catch(Exception err) {
          IOController.showMessage(err.getMessage(), "Fail", false);
      }
          
      }

      else if(line[0].equals("transfer")){
        try {
          bank.transfer(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Float.parseFloat(line[3]));
          IOController.showMessage("Transfer successful!", "Success", true);
        }catch(ArrayIndexOutOfBoundsException err) {
          IOController.showMessage("Many arguments passed!", "Fail", false);
        }catch(NumberFormatException err) {
          IOController.showMessage("Invalid value passed by argument","Fail", false);
        }catch(Exception err) {
          IOController.showMessage(err.getMessage(),"Fail", false);
        }
      }

      else if(line[0].equals("withdraw")) {
        try {
          bank.withdraw(Integer.parseInt(line[1]), Float.parseFloat(line[2]));
          IOController.showMessage("Withdraw successful!", "Success", true);
        }catch(ArrayIndexOutOfBoundsException err) {
          IOController.showMessage("Many arguments passed!", "Fail", false);
        }catch(NumberFormatException err) {
          IOController.showMessage("Invalid value passed by argument","Fail", false);
        }catch(Exception err) {
          IOController.showMessage(err.getMessage(),"Fail", false);
        }
      }
      
      else if(line[0].equals("update")) {
        bank.update();
        IOController.showMessage("Updated successful!", "Success", true);
      }
      
      else if(line[0].equals("show")) {
        IOController.showMessage(bank.toString(), "Accounts", true);
      }

      else
        IOController.showMessage("Invalid command", "Fail", false);
    }
  }
}

