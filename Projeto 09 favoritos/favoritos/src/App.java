
//util 
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

//models
import models.Contact;
import models.Phone;
import models.Phonebook;

public class App {

    public static void showMessage(String message) {
        Pattern pattern = Pattern.compile("Success message");
        Pattern pattern2 = Pattern.compile("Contacts found");

        Matcher matcher = pattern.matcher(message);
        Matcher matcher2 = pattern2.matcher(message);

        if(matcher.find() || matcher2.find())
            JOptionPane.showMessageDialog(null, message, "Success message", 1);
        else
            JOptionPane.showMessageDialog(null, message, "Error message", 0);
    }

    public static void main(String[] args) throws Exception {
       Phonebook agenda = new Phonebook();

       while(true) {
            String[] line = JOptionPane.showInputDialog(null,
                                        "Chosen an option:\n" +
                                        "- add {name} {label:number} ...\n" +
                                        "- rmContact {name}\n" +
                                        "- rmPhone {name}, {index}\n" +
                                        "- star {name}\n" +
                                        "- unstar {name}\n" +
                                        "- search {pattern}\n" +
                                        "- get {name}\n" +
                                        "- show\n" +
                                        "- end\n" 
                                        ).split(" ");
            
            if(line[0].equals("end"))
                break;
            
            else if(line[0].equals("add")) {
                    
                try {

                    ArrayList<Phone> phones = new ArrayList<Phone>();

                    for(int i = 2; i < line.length; i++) {
                        String[] phoneParts = line[i].split(":");
                        phones.add(new Phone(phoneParts[0], phoneParts[1]));
                    }

                    String solve = agenda.addContact(line[1], phones);
                    App.showMessage(solve);
                
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Phone invalid");
                }
            }
            
            else if(line[0].equals("rmContact")) {
                
                try {

                    boolean solve = agenda.rmContact(line[1]);
                    if(solve)
                        App.showMessage("Success message: Contact were removed with Success!");
                    else
                        App.showMessage("Error message: Dont exists one contact with this name");
                
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Many arguments passed!");
                }
            }
            
            else if(line[0].equals("rmPhone")) {
                try {

                    boolean solve = agenda.rmPhone(line[1], Integer.parseInt(line[2]));
                    if(solve)
                        App.showMessage("Success message: Phone removed with Success!");
                    else
                        App.showMessage("Error message: Contact " + line[1] + " does not exists or index invalid!");

                }catch(NumberFormatException err) {
                    JOptionPane.showMessageDialog(null,
                                "Error message: Invalid number!",
                                "Error message", 
                                0    
                                );
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Many arguments passed!");
                }
            }
            
            else if(line[0].equals("star")) {
                try {
                    String solve = agenda.BookMark(line[1]);
                    App.showMessage(solve);
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Many arguments passed!");
                }
            }
            
            else if(line[0].equals("unstar")) {
                try {
                    String solve = agenda.UnBookMark(line[1]);
                    App.showMessage(solve);
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Many arguments passed!");
                }
            }
        
            else if(line[0].equals("search")) {
                try {
                    ArrayList<Contact> contacts = agenda.search(line[1]);

                    StringBuilder solve = new StringBuilder();
                    solve.append("Contacts found:\n");
                    for(int i = 0; i < contacts.size(); i++) {
                        solve.append(contacts.get(i).toString() + "\n");
                    }

                    App.showMessage(solve.toString());
                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Many arguments passed!");
                }
            }

            else if(line[0].equals("show")) {
                ArrayList<Contact> contacts = agenda.getContacts();
                StringBuilder solver = new StringBuilder();
                solver.append("Contacts found:\n");
                for(int i = 0; i < contacts.size(); i++) {
                    solver.append(contacts.get(i).toString() + "\n");
                }

                App.showMessage(solver.toString());
            }
            
            else if(line[0].equals("get")) {
                try {
                    Contact contact = agenda.getContact(line[1]);

                    if(contact == null)
                        App.showMessage("Error message: Contact " + line[1] + " does not exists!");
                    else
                        App.showMessage("Success message: Contact found!\n" + contact.toString());

                }catch(ArrayIndexOutOfBoundsException err) {
                    App.showMessage("Error message: Many arguments passed!");
                }
            }

            else {
                App.showMessage("Error message: invalid comand!");
            }
        }
    }
}
