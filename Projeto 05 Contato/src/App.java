import Models.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Contact contactUi = null;
        Scanner input = new Scanner(System.in);

        while(true) {
            String[] arrayLine = input.nextLine().split(" ");

            if(arrayLine[0].equals("end"))
                break;
            else if(arrayLine[0].equals("init"))
                contactUi = new Contact(arrayLine[1]);
            else if(arrayLine[0].equals("add"))
                contactUi.addPhone(arrayLine[1], arrayLine[2]);
            else if(arrayLine[0].equals("remove"))
                contactUi.removePhone(Integer.parseInt(arrayLine[1]));
            else if(arrayLine[0].equals("show"))
                System.out.println(contactUi);
        }
    }
}
