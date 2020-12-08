package Bank;

//Importes necessários
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	
	//Variáveis estáticas
	static ArrayList<AccountBank> accounts = new ArrayList<AccountBank>();
	static Scanner input = new Scanner(System.in);
	
	//Checa se existe uma conta com o número dado
	public static boolean checkAccountExists(int numberAccount) {
	      return (numberAccount >= 0 && numberAccount <= accounts.size() - 1);
	}
		
	
	//Funções interativas
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
	                    
	                    input.nextLine(); //Capturo o buff
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
	                    int numberAccountAcess = Integer.parseInt(arrayLine[0]);
	                    float valueTransfer = Float.parseFloat(arrayLine[1]);
	                    //Instancio a conta que irá receber a transferência
	                    AccountBank other = accounts.get(numberAccountAcess);
	                    acessAccount.transferMoney(valueTransfer, other);
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
		
		//p/ controle de looping
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
