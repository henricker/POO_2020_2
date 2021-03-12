package view;

import controllers.WhatsappService;
import exceptions.ExceptionController;
import util.MessageController;

public class View {
    private WhatsappService whatsapp;

    public View() {
        this.whatsapp = new WhatsappService();
    }

    public void run() {
        while(true) {
            String line[] = MessageController.inputUser();

            if(line[0].equals("End"))
                break;
            
            else if(line[0].equals("CreateUser:")) {
                try {
                    this.whatsapp.createUser(line[1]);
                    MessageController.showMessage("User" + line[1] + " create successfully", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("CreateGroup:")) {
                try {
                    this.whatsapp.createGroup(line[1], line[2]);
                    MessageController.showMessage("Group" + line[1] + " create successfully", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("Invite:")) {
                try {
                    this.whatsapp.invite(line[1], line[2], line[3]);
                    MessageController.showMessage(line[2] + " was invited successfully", "Success", true);
                } catch (IndexOutOfBoundsException err) {
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
                    this.whatsapp.sendMessage(line[1], line[2], sb.toString());
                    MessageController.showMessage("Message sent successfully", "Success", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("GetNotifyUser:")) {
                try {
                    String data = this.whatsapp.getNofityUser(line[1]);
                    MessageController.showMessage(data, "Notify chats", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("ReadChatMessage:")) {
                try {
                    String data = this.whatsapp.getChatMessage(line[1], line[2]);
                    MessageController.showMessage(data, line[2] + " [ messages ]", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("ReadUnreadChatMessage:")) {
                try {
                    String data = this.whatsapp.getUnreadChatMessage(line[1], line[2]);
                    MessageController.showMessage(data, line[2] + " [ messages ]", true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("CreateChat:")) {
                try {
                    this.whatsapp.createChat(line[1], line[2]);
                    MessageController.showMessage("Chat created successfully!", "Success" , true);
                } catch (IndexOutOfBoundsException err) {
                    MessageController.showMessage("Few arguments!", "Error message", false);
                } catch(ExceptionController err) {
                    MessageController.showMessage(err.getMessage(), err.getType(), false);
                }
            }

            else if(line[0].equals("RemoveUser:")) {
                try {
                    this.whatsapp.removeUserChat(line[1], line[2]);
                    MessageController.showMessage(line[1] + " Successfully left the group", "Success" , true);
                } catch (IndexOutOfBoundsException err) {
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
