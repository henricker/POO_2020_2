package models;

class SavingsAccount extends Account {

    private static double income =  0.01;

    SavingsAccount(String idClient){
        super(idClient);
        this.type = "CP";
    }

    @Override
    public void monthAtualization() { 
        this.balance += (float) (this.balance * SavingsAccount.income);
    }
    
}
