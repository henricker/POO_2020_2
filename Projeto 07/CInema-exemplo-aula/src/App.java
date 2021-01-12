import models.Cine;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Cine cinema = null;
        while(true) {
            String[] line = JOptionPane.showInputDialog(
                    "Options: \n" +
                    "- show\n" +
                    "- init {value_here}\n" +
                    "- reserve {name_client} {phone_client} {index_chair}\n" +
                    "- cancel {name_client}"
                ).split(" ");

            if(line[0].equals("init")) {
                try {
                    cinema = new Cine(Integer.parseInt(line[1]));
                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Value invalid!", 
                        "Error!",
                        JOptionPane.ERROR_MESSAGE
                    );
                    System.err.println(err);
                }
            }

            else if(line[0].equals("show")) {
                if(cinema == null) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "[ ]", 
                        "Chairs of the cinema", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }else{
                    JOptionPane.showMessageDialog(
                        null, 
                        cinema.toString(), 
                        "Chairs of the cinema", 
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }

            else if(line[0].equals("reserve")) {
                try {
                cinema.toReserve(line[1], line[2], Integer.valueOf(line[3]));
                }catch(NullPointerException err) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Cinema dont initialized!",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            else if(line[0].equals("cancel")) {
                if(cinema.cancel(line[1])) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Caceled with sucessfully",
                        "Canceled",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
                else {
                    JOptionPane.showMessageDialog(
                        null,
                        "fail: This person do not exists in cinema",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            else if(line[0].equals("out"))
                break;
            else
                JOptionPane.showMessageDialog(null, "fail: operation invalid", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
