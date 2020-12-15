package Models;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<Phone> phoneNumbers = new ArrayList<Phone>();

    public Contact(String name) {
        this.name = name;
    }

    public void addPhone(String label, String number) {
        Phone element = new Phone(label, number);

        //If atributes are nulls, object element = null, deallocate memory
        if(element.getNumber() == null && element.getLabel() == null) {
            element = null;
            return;
        }

        phoneNumbers.add(element);
    }

    public void removePhone(int index) {
        if(phoneNumbers.size() == 0)
            return;
        
        phoneNumbers.remove(index);

        //Decrement the indexCurrent of the phone element
        for(int i = index; i < phoneNumbers.size(); i++)
            phoneNumbers.get(i).decreaseIndexCurrent();
    }

    public String toString() { 
        String data = "- " + this.name + " ";
        for(Phone object: phoneNumbers) {
            data += object.toString() + " ";
        }

        return data;
    }
}
