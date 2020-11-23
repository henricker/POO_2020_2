public class factorial {
    
    //Solucao em tempo exponencial...
    public static long factorialCalc(int value) {
        if (value == 1 || value == 0)
            return 1;
        else if (value == 2)
            return 2;

        return value * factorialCalc(value - 1);
    }

    public static void main(String[] args) {
        //Imprima o fatorial dos numeros no intervalo de  [1, 10]
        for (int i = 1; i <= 10; i++) {
            System.out.println( i + "!" + " = " + factorialCalc(i) + " ");
        }
        //finish
    }
}