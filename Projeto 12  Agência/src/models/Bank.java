package models;

import java.util.ArrayList;
import java.util.Arrays;

import exceptions.NameIsNotStringError;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Bank {
    ArrayList<Client> clients;
    ArrayList<Account> accounts;

    Bank() {
        this.clients = new ArrayList<Client>();
        this.accounts = new ArrayList<Account>();
    }

    public void AddClient(String name) throws NameIsNotStringError {
        Pattern pattern = Pattern.compile("[^[0-9]+$]");
        Matcher matcher = pattern.matcher(name);

        if(!matcher.find())
            throw new NameIsNotStringError("Just acept non-numeric characters!");
        
        if(this.findClient(name) != null)
            throw new NameIsNotStringError("This client already exists!");
        
        //create accounts and client
        CurrentAccount currentAccount = new CurrentAccount(name);
        SavingsAccount savingsAccount = new SavingsAccount(name);
        Client client = new Client(name);

        //Add accounts in client object
        client.getAccounts().addAll(new ArrayList<Account>(Arrays.asList(currentAccount, savingsAccount)));
        
        //Save client in ArrayList<Client>
        this.clients.add(client);

        //Save accounts in ArrayList<Account>
        this.accounts.addAll(new ArrayList<Account>(Arrays.asList(currentAccount, savingsAccount)));
    }

    public Client findClient(String name) {
        for(Client obj : this.clients)
            if(obj.getName().equals(name))
                return obj;
        
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public ArrayList<Client> getClients() {
        return this.clients;
    }
}
