import java.util.Random;
import java.util.Scanner;

public class Calango {
    
    private int life;
    private int stomash;
    private int MaxStomashCapacity;
    private int experience;
    private int walked;

    Calango(int MaxStomashCapacity) {
        this.MaxStomashCapacity = MaxStomashCapacity;
        this.life = 100;
        this.stomash = 0;
        this.experience = 0;
        this.walked = 0;
    }

    void huntBug() {
       
        System.out.println("Calanguinho inicia a sua busca voraz...");
        Random generator = new Random();
        int bugFinded = 0;

      
        if(this.experience >= 0 && this.experience <= 5) {
            bugFinded  = generator.nextInt(6);
        }
        else if(this.experience > 5 && this.experience <= 15 ) {
            bugFinded = generator.nextInt(16);
        }
        else if(this.experience > 16 && this.experience <= 45) {
            bugFinded = generator.nextInt(46);
        }
        else if(this.experience > 45 && this.experience <= 100) {
            bugFinded = generator.nextInt(101);
        }
        
        if(bugFinded == 0) {
            System.out.println("Nada encontrado, triste...\n");
            return;
        }

        System.out.println("Calanguim encontrou: " + bugFinded + " insetos");

        if(this.experience < 100) {
            this.experience += bugFinded;
            if(this.experience > 100){
                this.experience = 100;
                System.out.println("Atingi o patamar de deus dos calanguins, curvem-se diante de mim!!!!");
                System.out.println("HAHAHAHAHAHA (Risada malefica)");
                System.out.println("Nivel atual: " + this.experience + " nivel maximo!\n");
            }
            else{
                System.out.println("O pai ta fincando monstro!");
                System.out.println("Nivel atual: " + this.experience + "\n");
            }
        System.out.println("Apos sua busca voraz, calanguin irah comer o numero maximo de insetos que puder...");
        this.eating(bugFinded); // funcao responsavel para alimentar com a cacada do calanguim
        }
    }

    void eating(int bugFinded) {
        if (this.stomash == this.MaxStomashCapacity) {
            System.out.println("Calanguinho estah com buchin chei :)\n");
            return;
        }

        this.stomash += bugFinded;
        System.out.println("HUMMMMMMM que deliiiiiciaaaaa!");

        if (this.stomash > this.MaxStomashCapacity) {
            this.stomash = this.MaxStomashCapacity;
            System.out.println("To de buchin chei mah :)");
        }
        System.out.println();
    }

    void toWalk() {
        if (this.stomash == 0) {
            System.out.println("Calanguinho mesmo com fome ainda arrisca sua vida para passear...");
            this.walked += 1;
            this.life -= 10;
            if(this.life <= 0)
                this.killCalanguin();
        }
        else{
            this.walked += 1;
            this.stomash -= 1;
            System.out.println("Que passeio agradavel... :)\n");
        }
    }

    void killCalanguin() {
        this.life = 0;
        System.out.println("O calango estah morto...");
        return;
    }

    public String toString() {
        return "Life: " + this.life + " | stomash: " + this.stomash + "| Stomash capacity: " + this.MaxStomashCapacity
                + " | experience: " + this.experience + "| Walked: " + this.walked + "\n";
    }

    public static void main(String[] args) {
        //Falta apenas criar um menu interativo :)
    }
}