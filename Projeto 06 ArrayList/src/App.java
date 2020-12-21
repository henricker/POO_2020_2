import Models.Kid;
import Models.Trampoline;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Trampoline trampoline = new Trampoline();

        while(true) {
            String[] arrayLine = input.nextLine().split(" ");

            if(arrayLine[0].equals("arrive"))
                trampoline.arrive(new Kid(arrayLine[1], Integer.parseInt(arrayLine[2])));
            else if(arrayLine[0].equals("in"))
                trampoline.in();
            else if(arrayLine[0].equals("out"))
                trampoline.out();
            else if(arrayLine[0].equals("show"))
                System.out.println(trampoline);
            else if(arrayLine[0].equals("end"))
                break;
            else
                System.out.println("Comando inválido!");

        }

        input.close();
    }
}
