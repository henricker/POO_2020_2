package models;

//Util
import util.DoubleTwoDecimal;
import java.util.HashMap;

//Exception
import exceptions.LimitOverflowException;

public class Sector {
    private String name;
    private double price;
    private int quantity;
    private int capacity;
    private Event event;
    private HashMap<String, Person> clients;

    public Sector(String name, Event event, double price, int capacity) {
        this.name = name;
        this.price = DoubleTwoDecimal.doubleToDecimal(price);
        this.quantity = 0;
        this.capacity = capacity;
        this.event = event;
        this.clients = new HashMap<String, Person>();
    }

    public void saled(Person client) throws LimitOverflowException {
        if(this.quantity + 1 > this.capacity)
            throw new LimitOverflowException( this.name + " sector already had max capacity");
        this.quantity++;

        this.clients.put(client.getName(), client);
    }

    //all getters
    public String getName() { return this.name; }
    public double getPrice() { return this.price; }
    public int getQuantity() { return this.quantity; }
    public int getCapacity() { return this.capacity; }
    public HashMap<String, Person> getClients() { return this.clients; }

    @Override
    public String toString() {
        return "[ " + this.name + "|" + this.price + "|" + this.quantity + ":" + this.capacity + " ]";
    }
}
