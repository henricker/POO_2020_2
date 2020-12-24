package Models;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AccountBank {
    private double balance;
    private int numberAccount;
    private ArrayList<Operation> statements;

    public AccountBank(int numberAccount) {
        this.numberAccount = numberAccount;
        this.balance = 0;
        statements = new ArrayList<Operation>();

        Operation newOperation = new Operation("Open", 0, 0);
        statements.add(0, newOperation);
    }

    public void deposit(double value) {
        if(!(value > 0)) {
            JOptionPane.showMessageDialog(null, "Erro: Valor inválido!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.balance += value;
        Operation newOperation = new Operation("Deposit", value, this.balance);
        statements.add(newOperation);

        JOptionPane.showMessageDialog(null, "Deposit finish with sucessfully!", "Deposit", JOptionPane.INFORMATION_MESSAGE);
    }

    public void withdrawMoney(double value) {
        if(!(value > 0 && value <= this.balance)) {
            JOptionPane.showMessageDialog(null, "Erro: invalid value!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.balance -= value;
        Operation newOperation = new Operation("Withdraw", value*(-1), this.balance);
        statements.add(newOperation);

        JOptionPane.showMessageDialog(null, "Withdraw finish with sucessfully!", "Withdraw", JOptionPane.INFORMATION_MESSAGE);
    }

    public void tariff(double value) {
        if(!(value > 0 && value <= this.balance)){
            JOptionPane.showMessageDialog(null, "Erro: invalid value!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.balance -= value;
        Operation newOperation = new Operation("Tariff", value*(-1), this.balance);
        statements.add(newOperation);
        JOptionPane.showMessageDialog(null, "Rate withdraw from your account", "Tariff", JOptionPane.INFORMATION_MESSAGE);    
    }

    public String removeTarrif(int[] values) {
        String data = "";

        for(int i = 0; i < values.length; i++) {
            if(!(values[i] >= 0 && values[i] < statements.size())) {
                data += "Fail: index " + values[i] + " is invalid!\n";
                continue;
            }

            Operation op = statements.get(values[i]);

            if(!op.getDescription().equals("Tariff")) {
                data += "Fail: index " + values[i] + " is not a tariff!\n";
                continue;
            }

            this.balance += op.getValue()*(-1);
            Operation newOperation = new Operation("RemovedTarrif", op.getValue()*(-1), this.balance);
            statements.add(newOperation);
        }

        return data;
    }

    public String getStatements() { 
        String data = "--------------------------------------\n";
        for(Operation obj : statements) {
            data += statements.indexOf(obj) + ": " + obj.toString() + "\n";
        }

        return data;
    }

    public String getStatementsByN(int numberStatments) {
        if(!(numberStatments > 0 && numberStatments <= statements.size())) {
            JOptionPane.showMessageDialog(null, "Erro: invalid value!", "error", JOptionPane.ERROR_MESSAGE);
            return "";
        }
        String data = "--------------------------------------\n";
        for(int i = statements.size() - numberStatments; i < statements.size(); i++) {
            data += i + ": " + statements.get(i).toString() + "\n";
        }

        return data;
    }

    public String toString() { 
        return "--------------------------------------\n" + 
               " Account: " + this.numberAccount + "   Balance: " + this.balance + "\n" + 
               "--------------------------------------\n";
    }
}
