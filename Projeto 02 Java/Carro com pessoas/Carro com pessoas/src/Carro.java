import java.util.Scanner;

public class Carro {
    private int pass;
    private int passMax;
    private int gas;
    private int gasMax;
    private int km;

    Carro() {
        this.gas = 0;
        this.pass = 0;
        this.passMax = 2;
        this.gasMax = 100;
        this.km = 0;
    }

    //Embarcar uma pessoa por vez.
    void embarcar() {
        if(this.pass < passMax) {
            this.pass++;
            System.out.println("Entrou uma pessoa...\n");
            return;
        }
        //Não embarque além do limite
        System.out.println("Carro esta lotado...\n");
    }

    //Desembarcar uma pessoa por vez.
    void desembarcar() {
        if(this.pass > 0) {
            this.pass--;
            System.out.println("Saiu uma pessoa...\n");
            return;
        }
        // nao desembarque se não houver ninguém no carro.
        System.out.println("O carro ja esta vazio...\n");
    }

    //Abastecer o tanque passando a quantidade de litros de combustível
    void abastecer(int liters) {
        if(this.gas == this.gasMax) {
            System.out.println("O carro ja esta cheio!...\n");
            return;
        }

        this.gas += liters;

        //Caso tente abastecer acima do limite, descarte o valor que passou.
        if(this.gas > this.gasMax)
            this.gas = this.gasMax;
        System.out.println("Carro abastecido!...\n");
    }

    //Dirigir a uma determinada distancia
    void dirigir(int distance) {
        if(this.pass == 0) {
            System.out.println("Nao ha ninguem para dirigir o carro...\n");
            return;
        }
        if(this.gas == 0) {
            System.out.println("Tanque vazio!...\n");
            return;
        }

        // O CARRO FAZ 1KM POR 1L

        // analisando se eh possivel dirigir todo o percurso
        if(this.gas < distance) {
            this.km += this.gas;
            System.out.println("Tanque vazio apos andar " + this.gas + " km\n");
            this.gas = 0;
            return;
        }

        //Caso contrario, o carro pode percorrer a distancia indicada
        this.km += distance;
        this.gas -= distance;
    }

    public String toString() {
        return "Pass: " + this.pass + ", gas: " + this.gas + ", distance: " + this.km + "\n";
    }

    public static void main(String[] args) {
        Carro car = new Carro();
        Scanner input = new Scanner(System.in);
        //Main interativa
        while(true) {
            System.out.println("--------------Controller Carro---------------");
            System.out.println("* Embarcar: 'in'");
            System.out.println("* Desembarcar: 'out'");
            System.out.println("* Abastecer: 'fuel value_liters'");
            System.out.println("* Dirigir: 'drive value_distance'");
            System.out.println("* Show: 'show'");
            System.out.println("* Sair: 'sair'\n");

            System.out.print("Sua opcao: ");
            String line = input.nextLine();

            String[] Array = line.split(" ");

            if(Array[0].equals("in")) {
                car.embarcar();
            }
            else if(Array[0].equals("out")) {
                car.desembarcar();
            }
            else if(Array[0].equals("fuel")) {
                car.abastecer(Integer.parseInt(Array[1]));
            }
            else if(Array[0].equals("drive")) {
                car.dirigir(Integer.parseInt(Array[1]));
            }
            else if(Array[0].equals("show")) {
                System.out.println(car);
            }
            else if(Array[0].equals("sair")) {
                break;
            }
            else {
                System.out.println("Comando invalido!");
            }
        }
    }
}