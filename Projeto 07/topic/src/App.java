import javax.swing.JOptionPane;

import models.Bus;
import models.Passenger;


public class App {
    public static void main(String[] args) throws Exception {
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
                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Fail: you send age with characters not numerics, try again",
                        "Error!",
                        0
                    );
                }catch(NullPointerException err) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Fail, the bus were dont initialized",
                        "Error!",
                        0
                    );
                }catch(ArrayIndexOutOfBoundsException err) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Fail, you dont passed all data required",
                        "Error!",
                        0
                    );
                }
            }

            else if(input[0].equals("out")) {
                if(bus != null) {
                    try {
                        bus.out(input[1]);
                    }catch(ArrayIndexOutOfBoundsException err) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Fail, you dont passed all data required",
                            "Error!",
                            0
                        );
                    }
                }
                else {
                    JOptionPane.showMessageDialog(
                        null,
                        "Fail, you dont initialized the bus, try again",
                        "Error!",
                        0
                    );
                }
            }

            else if(input[0].equals("init")) {
                try {
                    bus = new Bus(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Fail: you send characters not numerics, try again",
                        "Error!",
                        0
                    );
                }
            }
            
            else if(input[0].equals("show")) {
                if(bus == null) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "[ ]",
                        "Passengers",
                        1
                    );
                }
                else {
                    JOptionPane.showMessageDialog(
                        null,
                        bus.toString(),
                        "Passengers",
                        1
                    );
                }

            }
       }
    }
}
