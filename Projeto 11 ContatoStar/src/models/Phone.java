
package models;


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
        String valid = "0123456789()-";
        for(char c : number.toCharArray()) {
            if(valid.indexOf(c) < 0)
                return false;
        }

        return true;
    }

    @Override
    public String toString() { 
        return this.label + " : " + this.number;
    }
}