package models;

public class Passenger {
    private String name;
    private int age;
    
    public Passenger (String name, int age) {
        this.name = name;
        this.age = age;
    }

    //all getters
    public String getName() { return this.name; }
    public int getAge() { return this.age; }

    public String toString () {
        return "[" + this.name + ":" + this.age + "]";
    }

}
