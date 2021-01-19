package models;

//Regular expressions
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.JOptionPane;

public class Phone {

    private String id;
    private String number;

    public Phone(String id, String number) { 
        this.id = id;
        this.number = number;
    }


    // Static method
    public static boolean isPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(number);

        if(matcher.matches())
            return true;

        return false;
    }

    //getters
    public String getid() { return this.id; }
    public String getNumber() { return this.number; }

    //toString
    public String toString() { 
        return this.id + " : " + this.number;
    }

}