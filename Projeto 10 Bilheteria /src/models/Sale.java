package models;

import util.DoubleTwoDecimal;

public class Sale {
    private Person client;
    private Sector sector;
    private Event event;
    private double value;

    public Sale(Person client, Sector sector, Event event, double value) {
        this.client = client;
        this.sector = sector;
        this.event = event;
        this.value = DoubleTwoDecimal.doubleToDecimal(value);
    }

    //all getters
    public Person getClient() { return this.client; }
    public Sector getSector() { return this.sector; }
    public Event getEvent() { return this.event; }
    public double getValue() { return this.value; }

    @Override
    public String toString() {
        return "[ " + this.client.getName() + " " + this.event.getName() + " " + this.sector.getName() + " ]";
    }
}
