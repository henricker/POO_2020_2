package models;

import java.util.ArrayList;

class Client {
    private String name;
    ArrayList<Account> accounts;
    
    Client(String name) {
        this.name = name;
        accounts = new ArrayList<Account>();
    }

    public String getName() { return name; }

    public ArrayList<Account> getAccounts() { return this.accounts; }

    public Account findAccount(int id) throws Exception {
        if(id < 0 || id > this.accounts.size())
            throw new Exception("This account dont exist");
        
        return this.accounts.get(id);
    }
}
