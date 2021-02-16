package view;

//exception
import exceptions.ExceptionController;
//model controller
import controller.WhatsappService;
//util
import util.MessageController;

public class View {
    WhatsappService whatsapp;

    public View() {
        this.whatsapp = new WhatsappService();
    }
    public void run() throws ExceptionController{
        while(true) {
            String line[] = MessageController.inputUser();

            if(line[0].equals("End"))
                break;
            
            else if(line[0].equals("CreateUser:")) {
                try {
                    this.whatsapp.createUser(line[1]);
                    MessageController.showMessage("User" + line[1] + " create successfully", "Success", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("CreateChat:")) {
                try {
                    this.whatsapp.createChat(line[1], line[2]);
                    MessageController.showMessage("Chat" + line[1] + " create successfully", "Success", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("Invite:")) {
                try {
                    this.whatsapp.addByInvite(line[1], line[2], line[3]);
                    MessageController.showMessage(line[2] + " invited " + line[2] + " with successfully", "Success", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("SendMessage:")) {
                try {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 3; i < line.length; i++)
                        sb.append(line[i] + " ");
                    this.whatsapp.sendMessage(line[1], line[2], line[3]);
                    MessageController.showMessage("Message sended with successfully", "Success", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("ReadMessage:")) {
                try {
                    String data = this.whatsapp.readMessage(line[1], line[2]);
                    MessageController.showMessage(data, "Inbox - [ " + line[2] + " ]", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("GetNotifyUser:")) {
                try {
                    String data = this.whatsapp.getNotifyUser(line[1]);
                    MessageController.showMessage(data, "User - [ " + line[1] + " ]", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("GetChatsByUser:")) {
                try {
                    String data = this.whatsapp.getChatsUser(line[1]);
                    MessageController.showMessage(data, line[1] + " - [ Chats ]", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("GetUsersByChat:")) {
                try {
                    String data = this.whatsapp.getUsersChat(line[1]);
                    MessageController.showMessage(data, line[1] + " - [ users ]", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("GetAllUsers")) {
                try {
                    String data = this.whatsapp.getAllUsers();
                    MessageController.showMessage(data, "[ Users ]", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                }
            }

            else if(line[0].equals("GetAllChats")) {
                try {
                    String data = this.whatsapp.getAllChats();
                    MessageController.showMessage(data, "[ Chats ]", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                }
            }

            else if(line[0].equals("RemoveUser:")) {
                try {
                    this.whatsapp.removeUser(line[1], line[2]);
                    MessageController.showMessage(line[1] + " removed with successfully!", "Remove success", true);
                } catch(IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else
                MessageController.showMessage("Invalid command!", "Error message", false);
        }
    }
}
