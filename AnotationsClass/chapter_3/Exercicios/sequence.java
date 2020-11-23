
import java.util.Scanner;

public class sequence {
    public static void main(String[] args) {
        /* 
            Dado um numero n, imprima a seguinte sequencia:
            1
            2 4
            3 6 9
            n n*2 n*3 ... n*n
        */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }

        //finish
    }
}