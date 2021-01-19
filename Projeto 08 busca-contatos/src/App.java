import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

//models
import models.Contact;
import models.Phone;
import models.Phonebook;

public class App {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        while(true) {
            String[] input = JOptionPane.showInputDialog(
                "----- Phonebook ----- \n" +
                "$add {name} {id:number} {id:number} ...\n" +
                "$addPhone {name} {id:number}\n" +
                "$rmContact {name}\n" +
                "$rmPhone {name} {index_phone}\n" +
                "$findContact {name}\n" +
                "$search {pattern}\n" +
                "$show\n" +
                "$end\n"
            
            ).split(" ");

            if(input[0].equals("$end"))
                break;
            
            else if(input[0].equals("$add")) {
                ArrayList<Phone> phones = new ArrayList<Phone>();
                String name = input[1];

                for(int i = 2; i < input.length; i++) {
                    String[] dataPhone = input[i].split(":");
                    phones.add(new Phone(dataPhone[0], dataPhone[1]));
                }

                boolean ok = phonebook.addContact(name, phones);

                if(ok)
                    JOptionPane.showMessageDialog(null,"Contact added with successfully", "Sucess!", 1);
                else
                    JOptionPane.showMessageDialog(null,"Error on put contact!", "Error!", 0);
            }
            
            else if(input[0].equals("$addPhone")) {
                String[] dataPhone = input[2].split(":");
                boolean ok = phonebook.addPhone(input[1], dataPhone[0], dataPhone[1]);
                
                if(ok)
                    JOptionPane.showMessageDialog(null,"Phone appended in " + input[1], "Success!", 1);
                else
                    JOptionPane.showMessageDialog(null,"Error on add phone!", "Error!", 0);
            }

            else if(input[0].equals("$rmContact")) {
                boolean ok = phonebook.rmContact(input[1]);

                if(ok)
                    JOptionPane.showMessageDialog(null,"Contact deleted with sucessfully!", "Sucess", 1);
                else
                    JOptionPane.showMessageDialog(null, "Error on delete contact!", "Error!", 0);
            }

            else if(input[0].equals("$rmPhone")) {
                boolean ok = phonebook.rmPhone(input[1], Integer.parseInt(input[2]));

                if(ok)
                    JOptionPane.showMessageDialog(null, "Sucess on delete fone to " + input[1], "Sucess!", 1);
                else
                    JOptionPane.showMessageDialog(null, "Failed to delete fone to " + input[1], "Error!" ,0);
            }

            else if(input[0].equals("$findContact")) {
                Contact element = phonebook.getContact(input[1]);
                
                if(element == null)
                    JOptionPane.showMessageDialog(null, "This person does not exists!", "Error", 0);
                else
                    JOptionPane.showMessageDialog(null, element.toString(), "Contact founded!", 1);
            }

            else if(input[0].equals("$search")) {
                ArrayList<Contact> finded = phonebook.search(input[1]);

                String data = "";
                for(Contact obj : finded)
                    data += obj.toString() + "\n";
                
                JOptionPane.showMessageDialog(null, data, "Searched Contact", 1);
            }

            else if(input[0].equals("$show")) {
                ArrayList<Contact> contacts = phonebook.getContacts();
                String data = "";
                for(Contact obj : contacts) {
                    data += obj.toString() + "\n";
                }

                JOptionPane.showMessageDialog(null, data, "Phonebook", 1);
            }
        }
    }

}