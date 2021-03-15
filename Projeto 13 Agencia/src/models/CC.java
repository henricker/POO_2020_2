package models;

import models.interfaces.InterfaceAccount;

public class CC extends Account implements InterfaceAccount {
  
  private float tarifMonth;
  
  public CC(String idClient) {
    super(idClient, "CC");
    this.tarifMonth = 20;
  }

  @Override
  public void update() {
    this.balance -= this.tarifMonth;
  }
  
}
