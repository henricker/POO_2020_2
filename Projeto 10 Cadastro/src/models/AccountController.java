package models;

import java.util.ArrayList;

import exceptions.AccountDontExistsError;
import exceptions.NameIsNotStringError;

public class AccountController {
    private Bank bank;

    public AccountController() {
        this.bank = new Bank();
    }

    public void AddCli(String name) throws NameIsNotStringError {
        bank.AddClient(name);
    }

    public String show() {
        ArrayList<Account> accounts = bank.getAccounts();

        StringBuilder data = new StringBuilder();

        for(Account account : accounts)
            data.append(account + "\n");

        return data.toString();

    }
    
    public void deposit(int id, float value) throws Exception {
        if(id < 0 || id > this.bank.accounts.size())
            throw new IndexOutOfBoundsException("Invalid id account!");
        
        this.bank.accounts.get(id).deposit(value);
    }

    public void transfer(int from, int to, float value) throws Exception {
        if((from < 0 || from > this.bank.accounts.size()) || (to < 0 || to > this.bank.accounts.size()))
            throw new AccountDontExistsError("Some account that was passed does not exist!");
        
        this.bank.accounts.get(from).transfer(this.bank.accounts.get(to), value);
    }

    public void withdraw(int id, float value) throws Exception {
        if(id < 0 || id > this.bank.accounts.size())
            throw new IndexOutOfBoundsException("This account does not exist!");
        
        this.bank.accounts.get(id).withdraw(value);
    }

    public void update() {
        for(Account account : this.bank.accounts) {
            account.monthAtualization();
        }
    }

    public int getSizeAccounts() {
        return this.bank.accounts.size();
    }
    
}
