package Models;

public class Operation {
    private String description;
    private double value;
    private double balance;

    public Operation(String description, double value, double balance) {
        this.description = description;
        this.value = value;
        this.balance = balance;
    }

    public String getDescription() { return this.description; }
    public Double getValue() { return this.value; }

    public String toString() {
        return this.description + ": " + this.value + ": " + this.balance;
    }
}
