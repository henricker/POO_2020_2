package Models;

public class Kid {
    private String name;
    private int age;

    public Kid(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return this.name; }
    public int getAge() { return this.age; }

    public String toString() {
        return this.name + ":" + this.age + " ";
    }
}
