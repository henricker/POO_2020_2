package models;

import exceptions.InvalidValueError;

interface InterfaceAccount {

    public void withdraw(float value) throws InvalidValueError;
    public void deposit(float value) throws InvalidValueError;
    public void transfer(Account other, float value) throws InvalidValueError;
    public void monthAtualization();
    public float getBalance();
    public int getId();
    public String getIdClient();
    public String getType();
    public String toString();
    
}
