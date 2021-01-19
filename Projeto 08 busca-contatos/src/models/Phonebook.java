package models;

import java.util.ArrayList;
import java.util.Collections;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Phonebook {
    private ArrayList<Contact> contacts;

    public Phonebook() { 
        this.contacts = new ArrayList<Contact>();
    }
    
    public int findContact(String name) {
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equals(name))
                return i;
        }

        return -1;
    }

    public boolean addContact(String name, ArrayList<Phone> phones) {
        
        if(phones.size() == 0)
            return false;
        
        if(this.findContact(name) != -1)
            return false;

        //Check if exists any phone number invalid and remove
        for(Phone obj : phones) {
            if(!Phone.isPhoneNumber(obj.getNumber())) {
                int index = phones.indexOf(obj);
                phones.remove(index); 
            }
        }

        this.contacts.add(new Contact(name, phones));
        Collections.sort(contacts);
        return true;
        
    }

    public boolean addPhone(String name, String id, String number) {
        if(!Phone.isPhoneNumber(number))
            return false;

        int index = this.findContact(name);
        if(index == -1)
            return false;
        
        this.contacts.get(index).addPhone(id, number);
        return true;
    }

    public boolean rmContact(String name) {
        int index = this.findContact(name);
        if(index == -1)
            return false;
        
        this.contacts.remove(index);
        return true;
    }

    public boolean rmPhone(String name, int index) {
        int indexContact = this.findContact(name);
        if(indexContact == -1)
            return false;
        Contact element = this.contacts.get(indexContact);
        
        if(!element.rmPhone(index))
            return false;
        
        return true;
    }

    public Contact getContact(String name) {
        int index = this.findContact(name);
        
        if(index == -1)
            return null;
        return this.contacts.get(index);
    }

    public ArrayList<Contact> search(String find) {
        ArrayList<Contact> solver = new ArrayList<Contact>();

        Pattern patter = Pattern.compile(find);
        for(Contact obj : contacts) {
            Matcher matcher = patter.matcher(obj.toString());
            if(matcher.find())
                solver.add(obj);
        }

        return solver;
    }

    public ArrayList<Contact> getContacts() { return this.contacts; }
}