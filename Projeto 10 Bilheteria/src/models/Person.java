package models;

public class Person {
    private String name;
    private boolean half;

    public Person(String name, boolean half) {
        this.name = name;
        this.half = half;
    }

    //all getters
    public String getName() { return this.name; }
    public boolean getHalf() { return this.half; }

    @Override 
    public String toString() {
        String type = this.half ? "half" : "full";
        return "[ " + this.name + " | " + type + " ]";
    }
}
