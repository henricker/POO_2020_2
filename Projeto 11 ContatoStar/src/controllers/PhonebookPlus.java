package controllers;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.ExceptionController;
import models.*;

public class PhonebookPlus extends Phonebook {
    private TreeMap<String, Contact> bookMarks;
    
    public PhonebookPlus() {
        this.bookMarks = new TreeMap<String, Contact>();
    }

    @Override
    public void rmContact(String name) throws ExceptionController {
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in bookmarks", "ContactNotFound");
        
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");
        
        this.bookMarks.remove(name);
        this.getContacts().remove(name);
    }

    public void bookMark(String name) throws ExceptionController {
        if(this.hasContactPlus(name))
            throw new ExceptionController(name + " already exists in bookmarks", "ContactAlreadyExists");
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");
        
        ContactPlus contact = this.getContact(name);
        contact.setStarred(true);
        this.bookMarks.put(contact.getName(), contact);

    }

    public void unbookMark(String name) throws ExceptionController {
        if(!this.hasContactPlus(name))
            throw new ExceptionController(name + " not exists in bookmarks", "ContactNotFound");
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");

        ContactPlus contact = this.getContact(name);
        contact.setStarred(false);
        this.bookMarks.remove(name);
    }

    public String getBookMarks() {
        StringBuilder sb = new StringBuilder();
        this.bookMarks.values().forEach(contact -> {
            sb.append(contact + "\n");
        });

        return sb.toString();
    }

    public String search(String find) {
        
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile(find);

        for(Contact contact : this.getContacts().values()) {
            Matcher matcher = pattern.matcher(contact.toString());
            if(matcher.find())
                sb.append(contact + "\n");
        }
        
        return sb.toString();
    }

    public boolean hasContactPlus(String name) {
        return this.bookMarks.containsKey(name);
    }
}
