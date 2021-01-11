package models;

public class Client {
    
    private String name;
    private String phone;
    
    public Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //all getters
    public String getName() { return this.name; }
    public String getPhone() { return this.phone; }

    //toString 
    public String toString() {
        return this.name + ":" + this.phone;
    }
}
