package models;

import java.util.ArrayList;

public class Client {
  private String id;
  private ArrayList<Account> accounts;

  public Client(String id) {
    this.id = id;
    this.accounts = new ArrayList<Account>();
  }

  public String getId() {
    return this.id;
  }

  public ArrayList<Account> getAccounts() {
    return this.accounts;
  }
}
