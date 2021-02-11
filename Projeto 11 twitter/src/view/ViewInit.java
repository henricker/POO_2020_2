package view;

import javax.swing.JOptionPane;

import controller.TwitterController;
import exceptions.UserAlredyExistsException;
import exceptions.UserNotFoundException;
import models.User;

public class ViewInit {

    private static TwitterController twitter = new TwitterController();
    private ViewUser viewUser = new ViewUser(twitter, this);

    private void login() throws UserAlredyExistsException, UserNotFoundException {

        while (true) {
            String[] line = JOptionPane.showInputDialog(null,
                    "    ----- Twitter -----   \n" + 
                    "- AddUser: {username}\n" + 
                    "- Login: {username}\n" + 
                    "- Show: all users\n" +
                    "- End\n")
                    .split(" ");

            if (line[0].equals("End"))
                return;
            
            else if (line[0].equals("AddUser:")) {
                try {
                    twitter.addUser(line[1]);
                    ViewInit.showMessage(false, "User added with success!");
                } catch (UserAlredyExistsException err) {
                    ViewInit.showMessage(true, err.getMessage());
                } catch (IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments!");
                }
            }

            else if (line[0].equals("Login:")) {
                try {
                    User user = twitter.getUserByName(line[1]);
                    if(user != null){
                        ViewInit.showMessage(false, "Login successfully!");
                        viewUser.userView(user);
                    }else
                        ViewInit.showMessage(true, "User not found!");

                } catch (IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments!");
                }
            }
            
            else if(line[0].equals("Show:")) {
                ViewInit.showMessage(false, twitter.show());
            }

            else
                ViewInit.showMessage(true, "Invalid command!");
        }
    }

    protected static void showMessage(boolean error, String message) {
        if(error)
            JOptionPane.showMessageDialog(null, message, "Error", 0);
        else
            JOptionPane.showMessageDialog(null, message, "Success", 1);
    }

    public void init() throws UserAlredyExistsException, UserNotFoundException {
        this.login();
    }
}
