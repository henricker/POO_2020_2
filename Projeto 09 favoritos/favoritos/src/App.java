
//util 
import java.util.ArrayList;
import javax.swing.JOptionPane;

//models
import models.Contact;
import models.Phone;
import models.Phonebook;

public class App {
    public static void main(String[] args) throws Exception {
       Phonebook agenda = new Phonebook();

       while(true) {
            String[] line = JOptionPane.showInputDialog(null,
                                        "Chosen an option:\n" +
                                        "- add {name} {[label:number]} ...\n" +
                                        "- rmContact {name}\n" +
                                        "- rmPhone {name}, {index}\n" +
                                        "- star {name}\n" +
                                        "- unstar {name}\n" +
                                        "- show\n" +
                                        "- end\n" 
                                        ).split(" ");
            
            if(line[0].equals("end"))
                break;
       }
    }
}
