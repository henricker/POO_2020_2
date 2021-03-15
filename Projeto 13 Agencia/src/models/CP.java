package models;

import models.interfaces.InterfaceAccount;

public class CP extends Account implements InterfaceAccount {

  private double Yield;

  public CP(String idClient) {
    super(idClient, "CP");
    this.Yield = 1.01;
  }

  @Override
  public void update() {
    this.balance *= this.Yield;
  }
}
