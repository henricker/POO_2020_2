package controllers;
import java.util.TreeMap;

import models.*;

import exceptions.ExceptionController;

public abstract class Phonebook {
    private TreeMap<String, ContactPlus> contacts;

    public Phonebook() {
        this.contacts = new TreeMap<String, ContactPlus>();
    }

    public void addContact(String name) throws ExceptionController {
        if(this.hasContact(name))
            throw new ExceptionController(name + " already exists in phonebook", "ContacAlradyExists");
        
        this.contacts.put(name, new ContactPlus(name));    
    }

    public void rmContact(String name) throws ExceptionController {
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");
        this.contacts.remove(name);
    }

    public void AddPhone(String name, String label, String number) throws ExceptionController {
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");
        
        this.contacts.get(name).addPhone(label, number);
    }

    public void rmPhone(String name, int index) throws ExceptionController {
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");
        
        this.contacts.get(name).rmPhone(index);
    }

    public TreeMap<String, ContactPlus> getContacts() {
        return this.contacts;
    }

    public String getAllContacts() {
        StringBuilder sb = new StringBuilder();
        this.contacts.values().forEach(contact -> {
            sb.append(contact + "\n");
        });

        return sb.toString();
    }

    public ContactPlus getContact(String name) throws ExceptionController {
        if(!this.hasContact(name))
            throw new ExceptionController(name + " not exists in phonebook", "ContactNotFound");
        
        return this.contacts.get(name);    
    }

    public boolean hasContact(String name) {
        return this.contacts.containsKey(name);
    } 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.contacts.values().forEach(contact -> {
            sb.append(contact + "\n");
        });

        return sb.toString();
    }
}
