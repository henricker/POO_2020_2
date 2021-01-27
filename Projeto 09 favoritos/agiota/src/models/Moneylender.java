package models;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Moneylender {
    private double balance;
    private double interest;
    private TreeMap<String, Client> dictClients;
    private TreeMap<Integer, Transaction> dictTransactions;

    public Moneylender(double balance, double interest) {
        this.balance = balance;
        this.interest = interest;
        dictClients = new TreeMap<String, Client>();
        dictTransactions = new TreeMap<Integer, Transaction>();
    }

    public String addCli(String codename, double limit) {
        String response = "Sucess message: Client registered with succesfully!";

        // basic validations
        if (this.dictClients.containsKey(codename))
            return response = "Error message: Alredy exists one client with the same codename!";
        if (limit <= 0)
            return response = "Error message: Invalid limit value!";
        if (codename.equals(""))
            return response = "Error message: Codename can't be empty!";

        // Create client
        Client client = new Client(codename, limit);
        this.dictClients.put(codename, client);
        return response;
    }

    public String lend(String codename, double value) {
        String response = "Sucess message: Transaction registered!";

        // basic validations
        if (!this.dictClients.containsKey(codename))
            return response = "Error message: Dont exists one client with this codename!";

        if (this.balance < value)
            return response = "Error message: Insufficient funds!";

        if (value <= 0)
            return response = "Error message: invalid value!";

        if (this.dictClients.get(codename).getBalance() + value > this.dictClients.get(codename).getLimit())
            return response = "Error message: Limit exceeded!";

        // Case succes
        Transaction transaction = new Transaction(codename, value);
        this.dictClients.get(codename).receiveTransaction(this.interestCalc(value));
        this.dictTransactions.put(transaction.getId(), transaction);
        this.balance -= value;

        return response;
    }

    public String receive(String codename, double value) {
        String response = "Sucess message: Value receive with sucess!";

        // basic validations
        if (!this.dictClients.containsKey(codename))
            return response = "Error message: Dont exists one client with this codename!";
        if (value <= 0)
            return response = "Error message: Value is invalid!";
        if (value > this.dictClients.get(codename).getBalance())
            return response = "Error message: The customer cannot pay more than his debt";

        // case success
        Transaction transaction = new Transaction(codename, value * (-1));
        this.dictClients.get(codename).receiveTransaction(value * (-1));
        this.dictTransactions.put(transaction.getId(), transaction);
        this.balance += value;

        return response;
    }

    public String kill(String codename) {
        String response = "Sucess message: " + codename + " were killed! HAHAHAHAHAHAHAHA!";

        // basic validation
        if (!this.dictClients.containsKey(codename))
            return response = "Error message: Dont exists one client with this codename!";

        // case sucess
        this.dictClients.remove(codename);

        ArrayList<Integer> transactionBlackList = new ArrayList<Integer>();
        for (Entry<Integer, Transaction> entry : this.dictTransactions.entrySet()) {
            if(entry.getValue().getCodename().equals(codename))
                transactionBlackList.add(entry.getKey());
        }
        for(Integer key : transactionBlackList)
            this.dictTransactions.remove(key);
        
        return response;
    }

    public double interestCalc(double value) {
        return value * (1 + this.interest/100);
    }

    public String clientsInfo() {
        String data = "Clients:\n";

        for(Client client : this.dictClients.values())
            data += "- " + client.toString() + "\n";

        return data += "\n";
    }

    public String transactionInfo() {
        String data = "Transactions:\n";
        
        for(Transaction transaction : this.dictTransactions.values())
            data += "- " + transaction.toString() + "\n";

        data += "\nbalance: " + this.balance + "\n";
        return data;
    }
}