import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[] array = line.split(" ");       

        int acc = 0;
        for(int i = 0; i < array.length; i++)
            acc += Integer.parseInt(array[i]);
        
        System.out.println(acc);
        
        input.close();
    }

}