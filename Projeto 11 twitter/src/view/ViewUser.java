package view;

import javax.swing.JOptionPane;

import controller.TwitterController;
import exceptions.UserAlredyExistsException;
import exceptions.UserNotFoundException;
import models.User;

class ViewUser {
    private TwitterController twitter;
    private ViewInit viewInit;
    private User user;

    ViewUser(TwitterController twitter, ViewInit viewInit) {
        this.twitter = twitter;
        this.viewInit = viewInit;
    }

    public void userView(User user) throws UserNotFoundException, UserAlredyExistsException {
        this.user = user;
        
        while(true) {
            String[] line = JOptionPane.showInputDialog(
                "    --- Welcome " + user.toString() +" ---\n"+
                "- WriteTweet: { message }\n" +
                "- Follow: { other_username }\n" +
                "- Unfollow: { other_username }\n" +
                "- LikeTweet: { index (id) }\n" +
                "- UnlikeTweet: { index (id) }\n" +
                "- Unread: " + user.getUnread().size() + " new messages in your timeline!\n" +
                "- Timeline: see your timeline!\n" + 
                "- Logout\n"
            ).split(" ");


            if(line[0].equals("WriteTweet:")) {
                try {
                    StringBuilder message = new StringBuilder();
                    for(int i = 1; i < line.length; i++)
                        message.append(" " + line[i]);
                    this.twitter.addTweet(this.user, message.toString());
                    ViewInit.showMessage(false, "Tweet added successfully!");
                }catch(IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments!");
                }
            }
        
            else if(line[0].equals("Follow:")) {
                try {
                    this.twitter.follow(this.user, line[1]);
                    ViewInit.showMessage(false, "Follow " + line[1] + " with success!");
                }catch(IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments!");
                }catch(UserNotFoundException err) {
                    ViewInit.showMessage(true, err.getMessage());
                }
            }
            
            else if(line[0].equals("Unfollow:")) {
                try {
                    this.twitter.follow(this.user, line[1]);
                    ViewInit.showMessage(false, "Unfollow " + line[1] + " with success!");
                }catch(IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments!");
                }catch(UserNotFoundException err) {
                    ViewInit.showMessage(true, err.getMessage());
                }
            }
            
            else if(line[0].equals("LikeTweet:")) {
                try {
                    this.twitter.likeTweet(this.user, Integer.parseInt(line[1]));
                    ViewInit.showMessage(false, "Like tweet successfully!");
                } catch(NumberFormatException err) {
                    ViewInit.showMessage(true, "Index invalid!");
                } catch(IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments or invalid id");
                }
            }
            
            else if(line[0].equals("UnlikeTweet:")) {
                try {
                    this.twitter.unlike(this.user, Integer.parseInt(line[1]));
                    ViewInit.showMessage(false, "Unlike tweet successfully!");
                } catch(NumberFormatException err) {
                    ViewInit.showMessage(true, "Index invalid!");
                } catch(IndexOutOfBoundsException err) {
                    ViewInit.showMessage(true, "Few arguments or invalid id");
                }
            }
            
            else if(line[0].equals("Unread:")) {
                ViewInit.showMessage(false, twitter.unread(this.user));
            }
            
            else if(line[0].equals("Timeline:")) {
                ViewInit.showMessage(false, this.twitter.timeline(this.user));
            }
            
            else if(line[0].equals("Logout")) {
                return;
            }

            else
                ViewInit.showMessage(true, "Invalid command!");
        }
    }

}
