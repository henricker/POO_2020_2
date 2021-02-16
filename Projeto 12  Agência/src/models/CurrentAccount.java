package models;

class CurrentAccount extends Account {

    private static float tariffMonth = 20;

    CurrentAccount(String idClient){
        super(idClient);
        this.type = "CC";
    }

    @Override
    public void monthAtualization() { 
        this.balance -= CurrentAccount.tariffMonth;
    }
    
}
