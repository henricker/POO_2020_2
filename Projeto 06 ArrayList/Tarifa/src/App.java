import Models.AccountBank;

import javax.swing.JOptionPane;

public class App {
    
    public static void main(String[] args) throws Exception {
        AccountBank accountBank = null;
        while(true) {
            String[] valueInput = JOptionPane.showInputDialog(null, "Write what you wish to do: ").split(" ");

            if(valueInput[0].equals("end")){
                System.out.println("Operation finish!");
                break;
            }
            else if(valueInput[0].equals("init"))
                accountBank = new AccountBank(Integer.parseInt(valueInput[1]));
            else if(valueInput[0].equals("deposit")) 
                accountBank.deposit(Double.parseDouble(valueInput[1]));
            else if(valueInput[0].equals("withdraw")) 
                accountBank.withdrawMoney(Double.parseDouble(valueInput[1]));
            else if(valueInput[0].equals("tariff")) 
                accountBank.tariff(Double.parseDouble(valueInput[1]));
            else if(valueInput[0].equals("statements"))
                JOptionPane.showMessageDialog(null, accountBank.getStatements(), "Statements", JOptionPane.INFORMATION_MESSAGE);
            else if(valueInput[0].equals("statementsN"))
                JOptionPane.showMessageDialog(null, accountBank.getStatementsByN(Integer.parseInt(valueInput[1])), "Statements", JOptionPane.INFORMATION_MESSAGE);
            else if(valueInput[0].equals("removeTariff")) {
                int values[] = new int[valueInput.length - 1];

                for(int i = 0; i < valueInput.length - 1; i++)
                    values[i] = Integer.parseInt(valueInput[i+1]);
                
                JOptionPane.showMessageDialog(null, accountBank.removeTarrif(values), "Remove tariff", JOptionPane.INFORMATION_MESSAGE);   
            }
            else if(valueInput[0].equals("show"))
                JOptionPane.showMessageDialog(null, accountBank.toString(), "Status account", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "Invalid command!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
}
