import java.util.Scanner;
public class mago {
    String name;
    int mana;
    mago(String name) {
        this.name = name;
        this.mana = 100;
    }

    void fire() {
        this.mana -= 10;
        System.out.println("Que se faca fooogooo!!!\n");
    }

    void regenerar(int qntd) {
        this.mana += qntd;
        if(this.mana > 100)
            this.mana = 100;
        System.out.println("Quantidade " + qntd + " de mana regenerada!");
    }

    public String toString() {
        return "Nome: " + this.name;
    }

    public static void main(String[] args) {
        mago maguin = new mago("Joao das feiticaria");
        Scanner input = new Scanner(System.in);
        
        while(true) {
            String line = input.nextLine();
            String[] ui = line.split(" ");

            if(line.equals("end"))
                break;
            
            else if(ui[0].equals("init")) {
                maguin = new mago(ui[1]);
            }
            else if(ui[0].equals("show"))
                System.out.println(maguin);
            else if(ui[0].equals("fogo"))
                maguin.fire();
            else if(ui[0].equals("regenerar"))
                maguin.regenerar(Integer.parseInt(ui[1]));
            else
                System.out.println("Comando invalido!");
        }
    }
}
