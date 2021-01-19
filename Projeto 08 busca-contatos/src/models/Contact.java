package models;

import java.util.ArrayList;

public class Contact implements Comparable<Contact> {
    private String name;
    private ArrayList<Phone> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<Phone>();
    }

    public Contact(String name, ArrayList<Phone> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public boolean addPhone(String id, String number) {
        if (!Phone.isPhoneNumber(number))
            return false;
        Phone anyPhone = new Phone(id, number);
        phoneNumbers.add(anyPhone);
        return true;
    }

    public boolean rmPhone(int index) {
        if (phoneNumbers.size() == 0)
            return false;
        phoneNumbers.remove(index);
        return true;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public ArrayList<Phone> getPhones() {
        return this.phoneNumbers;
    }

    // toString
    public String toString() {
        String data = "- " + this.name + " : [ ";
        for (int i = 0; i < this.phoneNumbers.size(); i++)
            data += "[ " + i + " : " + this.phoneNumbers.get(i).toString() + " ]";

        return data += " ]";
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.getName());
    }

}
