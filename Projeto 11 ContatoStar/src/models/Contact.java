package models;

import java.util.ArrayList;

import exceptions.ExceptionController;

public abstract class Contact {
    private String name;
    private ArrayList<Phone> phones;
    

    public Contact(String name) {
        this.name = name;
        this.phones = new ArrayList<Phone>();
    }

    public void addPhone(String label, String number) throws ExceptionController {
        if(Phone.validationNumber(number))
            throw new ExceptionController(number + " is invalid!", "InvalidNumberException");
        
        this.phones.add(new Phone(label, number));
    }

    public void rmPhone(int index) throws ExceptionController {
        if(index < 0 && index >=phones.size())
            throw new ExceptionController(index + " is not a valid!", "IndexInvalidException");
        
        this.phones.remove(index);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Phone> getPhones() {
        return this.phones;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append( "- " + this.name + " : [ ");
        for(int i = 0; i < this.phones.size(); i++) {
            data.append("[ " + i + " : " + this.phones.get(i).toString() + " ]");
        }

        return data.append(" ]").toString();
    }
}
