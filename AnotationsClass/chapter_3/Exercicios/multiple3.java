public class multiple3 {
    public static void main(String[] args) {
        //Imprima todos os multiplos de 3 no intervalo de [1 a 100]
        for(int i = 1; i <= 100; i++) {
            if(i % 3 != 0)
                continue;
            System.out.print(i + " ");
        }

        //finish
    }   
}