package models;

import exceptions.InvalidValueError;

abstract class Account implements InterfaceAccount{
    private static int id_base = 0;
    protected int id;
    protected float balance;
    protected String idClient;
    protected String type;

    Account(String idClient){
        this.balance = 0;
        this.idClient = idClient;
        this.id = Account.id_base++;
    }

    public void withdraw(float value) throws InvalidValueError {
        if(value < 0 || value > this.balance)
            throw new InvalidValueError("Invalid value to withdraw!");
        
        this.balance -= value;
    }

    public void deposit(float value) throws InvalidValueError {
        if(value < 0)
            throw new InvalidValueError("Invalid value to deposit!");
        
        this.balance += value;
    }

    public void transfer(Account other, float value) throws InvalidValueError {
        if(value < 0 || value > this.balance)
            throw new InvalidValueError("Invalid value to transfer!");
        
        this.balance -= value;
        other.deposit(value);
    }

    public void monthAtualization() { /* Polimorfism in inherited classes*/ }

    public float getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getType() {
        return type;
    }
    
    public String toString() { 
        StringBuilder data = new StringBuilder();
        data.append(this.id + " : " + this.idClient + " : " + this.balance + " : " + this.type);

        return data.toString();
    }
}
