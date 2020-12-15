package Models;

import java.util.ArrayList; //ArrayList
import java.util.Arrays; //.asList()

public class Phone {
    private static int counter = 0; //Show index in toString
    private String label;
    private String number;
    private int indexCurrent;

    //Constructor
    public Phone(String label, String number) {
        if(!validationNumber(number)) {
            //As I cannot use try-catch in the main method, the validation will be done in the class itself
            //atributes receive null, and in main method if atributes == null, Object = null
            System.out.println("fail: fone invalido");
            this.label = null;
            this.number = null;
            return;
        }
        this.label = label;
        this.number = number;
        this.indexCurrent = counter++;
    }

    //Method responsible to validation phone number
    private boolean validationNumber(String number) {
        String[] arrayNumber = number.split("");
        ArrayList<String> validCharacters = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "(", ")", "."));

        for(String value : arrayNumber) {
            if(!validCharacters.contains(value))
                return false;
        }

        return true;
    }

    //Decrease indexCurrent, for each removal object phone in Contact.java
    public void decreaseIndexCurrent() { this.indexCurrent--; this.counter--;}
    public String getNumber() { return this.number; }
    public String getLabel() { return this.label; }
    
    public String toString() {
        return "[" + this.indexCurrent + ":" + this.label + ":" + this.number + "]";
    }
}
