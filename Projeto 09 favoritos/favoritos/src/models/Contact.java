package models;

import java.util.ArrayList;

public class Contact {
    private String name;
    private boolean starred;
    private ArrayList<Phone> phones;

    public Contact(String name) {
        this.name = name;
        this.starred = false;
        phones = new ArrayList<Phone>();
    }

    public String addPhone(String label, String number) {
        
        if(!Phone.validationNumber(number))
            return "Error message: Invalid number phone\n";
        
        phones.add(new Phone(label, number));
        return "Success message: Number added with Successfully!\n";
    }

    public String addPhone(ArrayList<Phone> phones) {

        ArrayList<String> InvalidPhones = new ArrayList<String>();
        for(int i = 0; i < phones.size(); i++) {
            if(!Phone.validationNumber(phones.get(i).getNumber())){
                InvalidPhones.add(phones.get(i).toString());
                phones.remove(i);
            }
        }

        this.phones.addAll(phones);

        if(InvalidPhones.size() > 0) {
            StringBuilder data = new StringBuilder();
            data.append("Error message: Invalid numbers! \n");
            for(int i = 0; i < InvalidPhones.size(); i++) {
                data.append("- " + InvalidPhones.get(i) + "\n");
            }

            return data.toString();
        }

        return "Success message: All numbers were added with Success!\n";
    }

    public boolean rmPhone(int index) {
        if(index < 0 || index >= this.phones.size())
            return false;
        
        this.phones.remove(index);
        return true;
    }

    public void setBookMark(boolean value) { this.starred = value; }

    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append(((this.starred) ? "@ " : "- ") + this.name + " : [ ");
        for(int i = 0; i < this.phones.size(); i++) {
            data.append("[ " + i + " : " + this.phones.get(i).toString() + " ]");
        }

        return data.append(" ]").toString();
    }
}
