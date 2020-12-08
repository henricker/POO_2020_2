import java.util.ArrayList;
import java.util.Scanner;

class Client {
    private String name;
    private int age;
    private String CPF;
    private String RG;

    Client(String name, int age, String CPF, String RG) {
        this.name = name;
        this.age = age;
        this.CPF = CPF;
        this.RG = RG;
    }
    String getName() {
        return this.name;
    }

    String getCPF() {
        return this.CPF;
    }

    String getRG() {
        return this.RG;
    }

    int getAge() {
        return this.age;
    }

    public String toString() {
        return "\n\n\n" +
               "------------------------------\n" + 
               "        Dados do cliente      \n" +
               "------------------------------\n" +
               "Nome: " + this.name + "\n" +
               "Idade: " + this.age + "\n" +
               "CPF: " + this.CPF + "\n" +
               "RG: " + this.RG + "\n";
    }
}

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

public class Bank {
    static ArrayList<AccountBank> accounts = new ArrayList<AccountBank>();
    static Scanner input = new Scanner(System.in);
    //Para evitar erros na limpeza do console, faço o tratamento de exceções

    public static boolean checkAccountExists(int numberAccount) {
        return (numberAccount >= 0 && numberAccount <= accounts.size() - 1);
    }

    public static void createAccount() { 
        String name;
        String CPF;
        String RG;
        int age;
        float initialDeposit;

        //Recebo os dados do usuário cliente
        System.out.println(
            "\n\n\n" +
            "--------------------------------\n" +
            "        Cadastro do cliente     \n" +
            "--------------------------------\n"
            );
        System.out.print("Nome: ");
        input.nextLine();
        name = input.nextLine(); 
        System.out.print("Idade: ");
        age = input.nextInt();
        System.out.print("CPF: ");
        CPF = input.next();
        System.out.print("RG: ");
        RG = input.next();
        System.out.print("Depósito inicial: ");
        initialDeposit = input.nextFloat();

        //Crio um objeto cliente
        Client somebody = new Client(name, age, CPF, RG);

        //Crio a conta do cliente
        AccountBank account = new AccountBank(somebody, (float)initialDeposit);

    
        //Adiciono a conta no array, onde fica todas as contas
        boolean add = accounts.add(account);
        //System.out.println(account);
        if(!add){
            System.out.println(
                "\n" +
                "------------------" +
                "Erro no cadastro"
            );
            return;
        }

        System.out.println(
            "\n\n\n" + 
            "===========================\n" +
            "  Conta criada com sucesso!\n" +
            "===========================\n" +
            "Número da sua conta: " + account.getNumberAccount() + "\n" +
            "Para efetuar o login, utilize esse número :)\n"
        );
        
    }

    public static void login() {
        System.out.print(
            "\n\n\n" +
            "-----------------------\n" +
            "         Login         \n" +
            "-----------------------\n" +
            "Informe o número da sua conta: "
            );
        int numberAccount = input.nextInt();
        /*
            iniciei um bloco try catch, pois caso o usuário forneça
            um número fora do range do meu array, retornaremos uma exceção
        */
        
        if(!checkAccountExists(numberAccount)) {
            System.out.println(
                "\n\n\n" + 
                "--------------------\n" +
                "A conta não existe!"
            );
            return;
        }
        
        //Caso a conta exista, instancio um objeto para conter essa conta
        //Delcaro uma variável para acesso da conta
        AccountBank acessAccount = accounts.get(numberAccount);


        boolean sair = false;
        while(!sair) {
            System.out.println(
            "\n\n\n" +
            "-------------------------\n" +
            "   Bem vindo a sua conta!\n" +
            "-------------------------\n" +
            "1 - Obter saldo\n" +
            "2 - Depositar\n" +
            "3 - Transferir\n" +
            "4 - Sacar\n" +
            "5 - Obter dados da conta\n" +
            "6 - Obter dados do cliente\n" +
            "0 - Retornar ao menu principal"
            );

            int getInput = input.nextInt();

            switch (getInput) {
                case 1:
                    System.out.println(
                        "\n" +
                        "--------------------------\n" +
                        acessAccount.checkBalance() + 
                        "--------------------------"
                    );
                    break;
                
                case 2:
                    System.out.println(
                        "\n" +
                        "---------------------------------\n" +
                        "Digite o valor a ser depositado: "
                    );
                    float depositValue = input.nextFloat();
                    acessAccount.deposit((float)depositValue);
                    break;
                
                case 3:
                    System.out.println(
                        "\n" +
                        "---------------------------------\n" +
                        "          Transferência          \n" +
                        "Digite o número da conta e o valor (ex: 10 10.65): "
                    );
                    input.nextLine(); //Capturo o
                    String line = input.nextLine();
                    String[] arrayLine = line.split(" ");

                    //Verificaremos se a conta para transferência existe
                    if(!checkAccountExists(Integer.parseInt(arrayLine[0]))){
                        System.out.println(
                            "\n" + 
                            "--------------------\n" +
                            "A conta não existe!"
                        );
                        continue; //Retorna ao menu do usuário
                    }

                    //Instancio a conta que irá receber a transferência
                    AccountBank other = accounts.get(Integer.parseInt(arrayLine[0]));
                    acessAccount.transferMoney(Integer.parseInt(arrayLine[0]), other);
                    break;
                
                case 4:
                    System.out.println(
                        "\n" +
                        "---------------------------------\n" +
                        "Digite o valor a ser sacado: "
                    );
                    float withdrawValue = input.nextFloat();
                    acessAccount.withdrawMoney((float)withdrawValue);
                    break;
                
                case 5:
                    System.out.println(acessAccount);
                    break;
                
                case 6:
                    acessAccount.showDataClient();
                    break;
                
                case 0:
                    System.out.println(
                        "\n" +
                        "-------------------------------\n" +
                        "  Retornando ao menu principal "
                    );
                    sair = true;
                    break;


            }
        }
    }

    public static void main(String[] args) {
        boolean out = false;
        while(!out) {    
            System.out.print(
                "\n\n\n" + 
                "------------------------------\n" +
                "         Banco Riquinho       \n" +
                "------------------------------\n" +
                "1 - Criar uma conta\n" +
                "2 - Login em uma conta\n" + //Para realizar o login, basta entrar com o número da sua conta
                "0 - sair\n" +
                "Sua opção: "
                );
            int getInput = input.nextInt();

            switch (getInput) {
                case 0:
                    System.out.println(
                        "\n" +
                        "--------------------------\n" +
                        "Você saiu do sistema!"
                    );
                    out = true; 
                    break;
                case 1:
                    Bank.createAccount();
                    break;
                case 2:
                    Bank.login();
                    break;
                default:
                    System.out.println(
                        "\n" +
                        "--------------------------\n" +
                        "Comando inválido!"
                    );
                    break;
            }
        }
        input.close();
    }
}