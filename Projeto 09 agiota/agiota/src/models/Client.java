package models;

class Client {
    private String codename;
    private double limit;
    private double balance;

    Client(String codename, double limit) {
        this.codename = codename;
        this.limit = limit;
        this.balance = 0;
    }
    
    public double getLimit() { return this.limit; }
    public double getBalance() { return this.balance; }
    public String getCodename() { return this.codename; }
    public void receiveTransaction(double value) { this.balance += value; }

    @Override
    public String toString() {
        return this.codename + ":" + this.balance + "/" + this.limit;
    }
}