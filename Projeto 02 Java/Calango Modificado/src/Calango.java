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
    /* 
        Nessa funcao importei a classe Random,
        para que eu possa gerar numeros aleatorios onde o calango possa receber

        Para realizar uma busca por comida
        o calango deve gastar 1 de energia de seu estomago.

        O calango so pode realizar uma busca, caso esteja VIVO

        A respeito da busca por insetos:
            
            -Para cada inseto buscado, o animal recebe +1 em seu nivel de 
            experiencia.
         
            - Apos a busca realizada, invoco o metodo eating, passando por
            parametro a quantidade de insetos que o animal conseguiu, e com 
            isso ele se alimenta do numero maximo possivel de insetos.

            - Caso o animal esteja com o estomago cheio, ele apenas ganha a
            experiencia por ter conseguido buscar.
        
        Utilizo a seguinte definicao para os niveis do calango para a busca:
            - Caso seja iniciante, (lv 0 a 5), pode no maximo conseguir 5 insetos
            - Caso seja adolescente (lv 6 a 15), pode no maximo conseguir 15 insetos
            - Caso seja adulto (lv 16, 45), pode no maximo conseguir 45 insetos.
            - Caso seja maior que isso, ele pode coletar ate 50 insetos
    */
        
        //Se estiver morto, nao faz nada...
        if(this.life == 0){
            System.out.println("Nao posso buscar alimentos, estou morto :(\n");
            return;
        }

        //Se nao tem comida na barriga, nao faz nada...
        if(this.stomash == 0) {
            System.out.println("Sem energias para buscar alimento, alimente-o com pelo menos 1 de energia para iniciar a caçada \n");
            return;
        }

        
        //Caso tenha energia, ele faz a busca dos insetos
        this.stomash -= 1; // retiro um de energia para a busca
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
            bugFinded = generator.nextInt(50);
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
                System.out.println("Nivel atual: " + this.experience + "\n");
            }
            if(this.stomash < this.MaxStomashCapacity) {
                System.out.println("Apos sua busca voraz, calanguin irah comer o numero maximo de insetos que puder...");
                this.eating(bugFinded); // funcao responsavel para alimentar com a cacada do calanguim
            }
        }
    }

    void eating(int bugFinded) {
        /*
            Essa eh a funcao responsavel por manter o nosso calango alimentado

            Ela fornece a quantidade de energia maxima possivel para o estomago do animal

            caso o calango ja esteja com o estomago cheio, nao faz nada.
        */
        if (this.stomash == this.MaxStomashCapacity) {
            System.out.println("Calanguinho estah com buchin chei :)\n");
            return;
        }

        this.stomash += bugFinded;
        System.out.println("HUMMMMMMM que deliiiiiciaaaaa!");
        if (this.stomash > this.MaxStomashCapacity) {
            this.stomash = this.MaxStomashCapacity;
            System.out.println("enxi o buchin agr :)");
        }
        System.out.println("Total de insetos no estomago: " + this.stomash);
        System.out.println();
    }

    void toWalk() {

        /* 
            Para que nosso calango possa caminhar,
            eh preciso que ele esteja vivo ( logico, ne :v)

            A moeda de troca para percorrer um kilometro eh um de energia no estomago do calango

            caso nao tenha energia, o calango sacrifica 10% de vida.
        */

        if(this.life == 0) {
            System.out.println("Um calango morto nao anda seu animal!");
            return;
        }

        if (this.stomash == 0) {
            System.out.println("Calanguinho mesmo com fome ainda arrisca sua vida para passear...");
            this.walked += 1;
            this.life -= 10;
            if(this.life <= 0)
                this.killCalanguin();
            
            System.out.println("Vida restante: " + this.life);
        }
        else{
            this.walked += 1;
            this.stomash -= 1;
            System.out.println("Que passeio agradavel... :)\n");
        }
    }

    void killCalanguin() {
        /*
            Esse metodo tira a vida do calango
        */
        this.life = 0;
        System.out.println("O calango estah morto...");
        return;
    }

    void buyLife(int extraLife) {
        /*
            Eh um metodo simples para regenerar a vida do nosso calanguinho
            
            O metodo recebe como parametro a quantidade de vida desejada que queira
            regenerar, e eh descontado a partir do nivel de experiencia

            exemplo:
                Se nosso calango estiver com uma vida de 20% e nivel de experiencia de 60
                caso queiramos adicionar 30% de vida:
                    O calango vai ficar com 50% de vida e 30 de nivel de experiencia
        */
        if(this.experience == 0) {
            System.out.println("Voce nao tem experiencia para comprar vida!!\n");
            return;
        }
        if(this.life == 100) {
            System.out.println("O calango ja esta com a vida cheia!\n");
            return;
        }

        this.life += extraLife;
        this.experience -= extraLife;
        if(this.life > 100)
            this.life = 100;
        
        System.out.println("regenerando vida...\n");
        System.out.println("Vida atual: " + this.life);
    }

    public String toString() {
        return "Life: " + this.life + " | stomash: " + this.stomash + "| Stomash capacity: " + this.MaxStomashCapacity
                + " | experience: " + this.experience + "| Walked: " + this.walked + "\n";
    }

    public static void main(String[] args) {
        Calango c = new Calango(20);
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("-=-==-=-=-=-=-=-=-");
            System.out.println("CONTROLLER CALANGO");
            System.out.println("-=-==-=-=-=-=-=-=-");
            System.out.println("- Caçada: 'buscar'");
            System.out.println("- Alimenar: 'comer numero_de_insetos'");
            System.out.println("- Caminhar: 'caminhar'");
            System.out.println("- Matar: 'matar'");
            System.out.println("- Regenerar vida: 'cura quantidade_cura'");
            System.out.println("- mostrar dados: 'show'");
            System.out.println("- Finalizar execucao: 'sair'\n\n");

            //recebendo valores de input
            System.out.print("Sua opcao: ");
            String receive = input.nextLine();
            String[] Array = receive.split(" ");
            System.out.println();

            if(Array[0].equals("comer")) {
                c.eating(Integer.parseInt(Array[1]));
            }
            else if(Array[0].equals("cura")) {
                c.buyLife(Integer.parseInt(Array[1]));
            }
            else if(Array[0].equals("buscar")) {
                c.huntBug();
            }
            else if(Array[0].equals("caminhar")) {
                c.toWalk();
            }
            else if(Array[0].equals("matar")) {
                c.killCalanguin();
                break; // Caso o calango morra, saia da execucao do programa
            }
            else if(Array[0].equals("show")) {
                System.out.println(c);
            }
            else if(Array[0].equals("sair")) {
                System.out.println("Finalizando execucao");
                break;
            }
        }
        input.close();
    }
}