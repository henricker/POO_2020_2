package controller;

import models.*;

import java.util.ArrayList;

public class Bank {
  private ArrayList<Client> clients;
  private ArrayList<Account> accounts;

  public Bank() {
    this.accounts = new ArrayList<Account>();
    this.clients = new ArrayList<Client>();
  }

  private Client getClient(String idClient) {
    for(Client client : this.clients) {
      if(client.getId().equals(idClient))
        return client;
    }
    return null;
  }

  public void addClient(String idClient) throws Exception {
    if(this.getClient(idClient) != null)
      throw new Exception("Client Already exists");
    
    Client client = new Client(idClient);
    CC cc = new CC(idClient);
    CP cp = new CP(idClient);

    client.getAccounts().add(cc);
    client.getAccounts().add(cp);

    this.clients.add(client);
    this.accounts.add(cc);
    this.accounts.add(cp);
  }

  //withdraw = sacar
  public void withdraw(int idAccount, float value) throws Exception {
    Account account = this.getAccount(idAccount);

    if(account == null)
      throw new Exception("Account not exists!");
    
    account.withdraw(value);
  }

  public void deposit(int idAccount, float value) throws Exception {
    Account account = this.getAccount(idAccount);

    if(account == null)
      throw new Exception("Account not exists!");
    
    account.deposit(value);
  }

  public void transfer(int idAccountSender, int idAccountReceiver, float value) throws Exception {
    Account accountSender = this.getAccount(idAccountSender);
    Account accountReceiver = this.getAccount(idAccountReceiver);

    if(accountSender == null)
      throw new Exception("Account " + idAccountSender + " not exists!");
    if(accountReceiver == null)
      throw new Exception("Account " + idAccountReceiver + " not exists");

    accountSender.transfer(accountReceiver, value);
  }

  public void update() {
    for(Account account : this.accounts) {
      if(account instanceof CC) {
        CC cc = (CC) account;
        cc.update();
      }
      else {
        CP cp = (CP) account;
        cp.update();
      }
    }
  }

  private Account getAccount(int idAccount) {
    for(Account account : this.accounts) {
      if(account.getId() == idAccount)
        return account;
    }
    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    this.accounts.forEach(account -> {
      sb.append(account + "\n");
    });

    return sb.toString();
  }
}
