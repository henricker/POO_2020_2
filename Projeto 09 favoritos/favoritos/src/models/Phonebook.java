package models;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook {
    private TreeMap<String, Contact> contacts;
    private TreeMap<String, Contact> bookMarks;

    public Phonebook() {
        this.contacts = new TreeMap<String, Contact>();
        this.bookMarks = new TreeMap<String, Contact>();
    }

    public String addContact(String name, ArrayList<Phone> phones) {
        String response = "";
        
        /*
            If a contact with the same name already exists       
        */
        if(this.contacts.containsKey(name)){
            response = this.contacts.get(name).addPhone(phones);
            return response;
        }
        
        /*
            If a contact with the same name does not yet exist
        */
        Contact newContact = new Contact(name);
        response = newContact.addPhone(phones);
        this.contacts.put(name, newContact);
        return response;
    }

    public boolean rmContact(String name) {
        if(!this.contacts.containsKey(name))
            return false;
        
        this.contacts.remove(name);
        this.bookMarks.remove(name);
        return true;
    }

    public boolean rmPhone(String name, int index) {
        if(!this.contacts.containsKey(name))
            return false;
        
        boolean solve = this.contacts.get(name).rmPhone(index); 
        return solve;
    }
    
    public ArrayList<Contact> getContacts() { 
        ArrayList<Contact> solver = new ArrayList<Contact>();
        for(Contact contact : this.contacts.values())
            solver.add(contact);
        
        return solver;
    }

    public ArrayList<Contact> getBookMarks() { 
        ArrayList<Contact> solver = new ArrayList<Contact>();
        for(Contact contact : this.bookMarks.values())
            solver.add(contact);
        
        return solver;
    }

    public Contact getContact(String name) { return this.contacts.get(name); }

    public String BookMark(String name) {
        if(!this.contacts.containsKey(name))
            return "Error message: User does not exists!";
        
        Contact contact = this.contacts.get(name);
        if(!this.bookMarks.containsKey(name)) {
            contact.setBookMark(true);
            this.bookMarks.put(name, contact);

            return "Success message: Now " + name + " is in your bookMarks!\n";
        }

        return "Error message: " + name + " is already in your bookMarks! :)\n";
    }

    public String UnBookMark(String name) {
        if(!this.contacts.containsKey(name))
            return "Error message: User does not exists!";
        
        Contact contact = this.contacts.get(name);
        if(this.bookMarks.containsKey(name)) {
            contact.setBookMark(false);
            this.bookMarks.remove(name);

            return "Success message: Now " + name + " is not in your bookMarks! :(\n";
        }

        return "Error message: " + name + " is not in your bookMarks!\n";
    }

    public ArrayList<Contact> search(String find) {
        
        ArrayList<Contact> solver = new ArrayList<Contact>();

        Pattern pattern = Pattern.compile(find);

        for(Contact contact : this.contacts.values()) {
            Matcher matcher = pattern.matcher(contact.toString());
            if(matcher.find())
                solver.add(contact);
        }
        
        return solver;
    }
}
