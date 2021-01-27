package models;

import java.util.regex.*;

public class Phone {
    private String label;
    private String number;

    public Phone(String label, String number) {
        this.label = label;
        this.number = number;
    }

    public String getLabel() { return this.label; }
    public String getNumber() { return this.number; }

    public static boolean validationNumber(String number) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(number);
        
        if(matcher.find())
            return true;
        return false;
    }

    @Override
    public String toString() { 
        return this.label + " : " + this.number;
    }
}