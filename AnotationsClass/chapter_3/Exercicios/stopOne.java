import java.util.Scanner;

public class stopOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();

        if(value == 1)
            System.out.println(value);
        
        while(value != 1) {
            if(value % 2 == 0)
                value = value / 2;
            else
                value = (3 * value) + 1;
            
            System.out.print(value + " ");
        }

        //finish
    }
}