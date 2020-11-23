public class fibonacci {

    public static void main(String[] args) {
        //Imprimir todos os elementos de fibonacci e parar quando existir um elemento maior que 100
        for(int i = 1; i <= 100; i++) {
            int fibonacciValue = fibonacciCalc(i);
            if(fibonacciValue > 100)
                break;
            System.out.print(fibonacciValue + " ");
        }

        //finish
    }

    //fibonacci recursivo em tempo exponencial...
    public static int fibonacciCalc(int value) {
        if(value == 1)
            return 0;
        else if(value == 2)
            return 1;
        return fibonacciCalc(value - 2) + fibonacciCalc(value -1);
    }
}