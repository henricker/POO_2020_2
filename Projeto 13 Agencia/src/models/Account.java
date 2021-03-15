package models;

public abstract class Account {

  private static int idAccount = 0;

  protected int id;
  protected float balance;
  protected String idClient;
  protected String type;

  // CC -> Conta corrente
  // CP -> Conta poupança
  public Account(String idClient, String type) {
    this.idClient = idClient;
    this.type = type;
    this.id = Account.idAccount++;
  }

  public void withdraw(float value) throws Exception {
    if(value <= 0 || value > this.balance)
      throw new Exception("Invalid value!");
    
    this.balance -= value;
  }

  public void deposit(float value) throws Exception {
    if(value <= 0)
      throw new Exception("Invalid value!");
    
    this.balance += value;
  }

  public void transfer(Account other, float value) throws Exception {
    if(value > this.balance)
      throw new Exception("Invalid value");
    
    this.balance -= value;
    other.deposit(value);
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return this.id + ":" + this.idClient + ":" + this.balance + ":" + this.type;
  }
}