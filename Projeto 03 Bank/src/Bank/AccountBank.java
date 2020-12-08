package Bank;

class AccountBank {
	
	public static int counter = 0;

    private Client somebody;
    private int numberAccount;
    private float balance;

    AccountBank(Client somebody, float initialDeposit) {
        this.somebody = somebody;
        this.balance = initialDeposit;
        this.numberAccount = counter++;
    }

    void deposit(float value) {
        if(value < 0){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Não aceitamos valores negativos, tente novamente"
            );
            return;
        }
        this.balance += value;
    }

    void withdrawMoney(float value){
        if(value < 0){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Não aceitamos valores negativos, tente novamente"
            );
            return;
        }
        if(this.balance == (float)0){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Você não tem saldo no banco!"
            );
            return;
        }
        if(value > this.balance){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Você não tem saldo suficiente para retirar essa quantia"
            );
            return;
        }

        this.balance -= value;
        System.out.println(
            "\n" +
            "---------------------------------------------------------\n" +
            "Valor retirado com sucesso!"
        );
    }

    void transferMoney(float value, AccountBank other) {
        if(value < 0){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Não aceitamos valores negativos, tente novamente"
            );
            return;
        }
        if(this.balance == (float)0){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Você não têm saldo no banco!"
            );
            return;
        }
        if(value > this.balance){
            System.out.println(
                "\n" +
                "---------------------------------------------------------\n" +
                "Você não tem saldo suficiente para transferir essa quantia!"
            );
            return;
        }

        this.balance -= value;
        other.deposit(value);
        System.out.println(
            "\n" +
            "---------------------------------------------------------\n" +
            "Transferência realizada com sucesso!"
        );
    }

    public String checkBalance() {
        return "O seu saldo atual é: " + this.balance +"\n";
    }

    public int getNumberAccount() {
        return this.numberAccount;
    }

    public void showDataClient() {
        System.out.println(this.somebody);
    }
    public String toString() {
        return  "\n\n\n" +
                "------------------------------\n" + 
                "     Dados da conta bancária  \n" +
                "------------------------------\n" +
                "Cliente: " + this.somebody.getName() + "\n" +
                "Número da conta: " + this.numberAccount + "\n" +
                "Seu saldo: " + this.balance; 
    }

}
