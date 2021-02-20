import javax.swing.JOptionPane;

import Exceptions.ExceptionController;
import models.Bus;
import models.Passenger;


public class App {
    
    public static void showMessage(String title, String message, boolean success) {
        JOptionPane.showMessageDialog(null, message, title, (success ? 1 : 0));
    }
    public static void main(String[] args) throws ExceptionController {
        Bus bus = null;
        
        while(true) {
            String[] input = JOptionPane.showInputDialog(
                null, 
                "init {quantity} {preferred_chairs} \n" +
                "show \n" +
                "in {name} {age} \n" +
                "out {name} \n" +
                "quit"
            ).split(" ");

            if(input[0].equals("quit"))
                break;
            
            else if(input[0].equals("in")) {
                try {
                    Passenger person = new Passenger(input[1], Integer.parseInt(input[2]));
                    bus.in(person);
                    App.showMessage("Success", "Passenger add successfully", true);
                }catch(NumberFormatException err) {
                    App.showMessage("Error", "Fail: you send age with characters not numerics, try again", false);
                }catch(NullPointerException err) {
                    App.showMessage("Error", "Fail: the bus were dont initialized", false);
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error", "Fail: you dont passed all data required", false);
                }catch(ExceptionController err) {
                    App.showMessage(err.getTitle(), err.getMessage(), false);
                }
            }

            else if(input[0].equals("out")) {
                if(bus != null) {
                    try {
                        bus.out(input[1]);
                        App.showMessage("Success", "Passenger out successfully", true);
                    }catch(ArrayIndexOutOfBoundsException err) {
                        App.showMessage("Error", "Fail: you dont passed all data required", false);
                    }catch(ExceptionController err) {
                        App.showMessage(err.getTitle(), err.getMessage(), false);
                    }
                }
                else {
                    App.showMessage("Error","Fail: you dont initialized the bus, try again", false);
                }
            }

            else if(input[0].equals("init")) {
                try {
                    bus = new Bus(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    App.showMessage("Success", "Bus initialized successfully!", true);
                }catch(NumberFormatException err) {
                    App.showMessage("Error","Fail: you send characters not numerics, try again", false);
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error", "Fail: you dont passed all data required", false);
                }
            }
            
            else if(input[0].equals("show")) {
                if(bus == null) 
                    App.showMessage("Passengers", "[ ]", true);
                else 
                    App.showMessage("Passengers", bus.toString(), true);  
            }

            else
                App.showMessage("Error", "Invalid command!", false);
        }
    }
}
