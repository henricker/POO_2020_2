package models;

class Transaction {
    private static int idIncrement = 0;
    private int id;
    private Double value;
    private String codename;

    Transaction(String codename, double value) {
        this.value = value;
        this.codename = codename;
        this.id = Transaction.idIncrement++;
    }

    public int getId() { return this.id; }
    public String getCodename() { return this.codename; }
    
    public String toString() { 
        return "id:" + this.id + " " + this.codename + ":" + this.value;
    }
}
