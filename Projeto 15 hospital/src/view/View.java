package src.view;

import src.controller.Hospital;
import src.error.Error;
import src.util.IOController;

public class View {
  private Hospital h;

  public View() {
    this.h = new Hospital();
  }

  public void run() throws Error {

    while(true) {
      String line[] = IOController.IO();

      if(line[0].equals("AddPatient:")) {
        try {
          for(int i = 1; i < line.length; i++){
            String patient[] = line[i].split("-");
            this.h.addPatient(patient[0], patient[1]);
          }

          IOController.showMessage("Patients added with successfully!", "Success", true);
        }
        catch(IndexOutOfBoundsException err) {
          IOController.showMessage("Any arguments missing!", "Few arguments", false);
        }catch(Error err) {
          IOController.showMessage(err.getMessage(), err.getType(), false);
        }
      }

      else if(line[0].equals("AddDoctor:")) {
        try {
          for(int i = 1; i < line.length; i++){
            String doctor[] = line[i].split("-");
            this.h.addDoctor(doctor[0], doctor[1]);
          }

          IOController.showMessage("Doctors added with successfully!", "Success", true);
        }
        catch(IndexOutOfBoundsException err) {
          IOController.showMessage("Any arguments missing!", "Few arguments", false);
        }catch(Error err) {
          IOController.showMessage(err.getMessage(), err.getType(), false);
        }
      }

      else if(line[0].equals("Tie:")) {
        try {
          this.h.tie(line[1], line[2]);
          IOController.showMessage("Relationship between doctor and patient entities created!", "Success", true);
        }
        catch(IndexOutOfBoundsException err) {
          IOController.showMessage("Any arguments missing!", "Few arguments", false);
        }catch(Error err) {
          IOController.showMessage(err.getMessage(), err.getType(), false);
        }
      }

      else if(line[0].equals("SendMessage:")) {
        try {
          StringBuilder message = new StringBuilder();
          for(int i = 3; i < line.length; i++)
            message.append(line[i] + " ");
          
          this.h.sendMessage(line[1], line[2], message.toString());
          IOController.showMessage("Message sended with success", "Success", true);
        }
        catch(IndexOutOfBoundsException err) {
          IOController.showMessage("Any arguments missing!", "Few arguments", false);
        }catch(Error err) {
          IOController.showMessage(err.getMessage(), err.getType(), false);
        }
      }

      else if(line[0].equals("Inbox:")) {
        try {
          String inbox = this.h.inbox(line[1]);
          IOController.showMessage(inbox, "Inbox", true);
        }
        catch(IndexOutOfBoundsException err) {
          IOController.showMessage("Any arguments missing!", "Few arguments", false);
        }catch(Error err) {
          IOController.showMessage(err.getMessage(), err.getType(), false);
        }
      }

      else if(line[0].equals("Show")) {
        try {
          String users = this.h.show();
          IOController.showMessage(users, "Users", true);
        }
        catch(IndexOutOfBoundsException err) {
          IOController.showMessage("Any arguments missing!", "Few arguments", false);
        }
      }

      else
        IOController.showMessage("Command not found", "Error", false);
    }

  }

}
