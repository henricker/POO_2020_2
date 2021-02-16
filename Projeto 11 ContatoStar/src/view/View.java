package view;
import controllers.*;
import exceptions.ExceptionController;
import util.MessageController;

public class View {
    private PhonebookPlus phonebook;
    public View() {
        this.phonebook= new PhonebookPlus();
    }

    public void run() {
        while(true) {
            String line[] = MessageController.inputUser();

            if(line[0].equals("End"))
                break;
            
            else if(line[0].equals("AddContact:")) {
                try {
                    this.phonebook.addContact(line[1]);
                    MessageController.showMessage("Contact added successfully!", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch (ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("RemoveContact:")) {
                try {
                    this.phonebook.rmContact(line[1]);
                    MessageController.showMessage("Contact removed successfully!", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch (ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("AddPhone:")) {
                try {
                    for(int i = 2; i < line.length; i++) {
                        String[] phone = line[i].split(":");
                        this.phonebook.AddPhone(line[1], phone[0], phone[1]);
                    }
                    MessageController.showMessage("Phones added successfully!", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch (ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("RemovePhone:")) {
                try {
                    this.phonebook.rmPhone(line[1], Integer.parseInt(line[2]));
                    MessageController.showMessage("Phones added successfully!", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch (ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                } catch( NumberFormatException err) {
                    MessageController.showMessage("Invalid index!","Error message", false);
                }
            }

            else if(line[0].equals("Search:")) {
                try {
                    String data = this.phonebook.search(line[1]);
                    MessageController.showMessage(data,"Search results" , true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                }
            }

            else if(line[0].equals("ShowAllContacts")) {
                try {
                    String data = this.phonebook.getAllContacts();
                    MessageController.showMessage(data,"Contacts" , true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                }
            }

            else if(line[0].equals("ShowBookMarks")) {
                try {
                    String data = this.phonebook.getBookMarks();
                    MessageController.showMessage(data,"Starred contacts" , true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                }
            }

            else if(line[0].equals("Star:")) {
                try {
                    this.phonebook.bookMark(line[1]);
                    MessageController.showMessage("Contact starred successfully!", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch (ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("Unstar:")) {
                try {
                    this.phonebook.unbookMark(line[1]);
                    MessageController.showMessage("Contact starred successfully!", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch (ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else
                MessageController.showMessage("Invalid command!", "Error message", false);
        }
    }
}