import models.*;

public class App {
    public static void main(String[] args) throws Exception {
        Moneylender moneylender = new Moneylender(500);
        moneylender.addCli("Henrique", 300);
        System.out.println(moneylender.lend("Henrique", 300));
        System.out.println(moneylender.receive("Henrique", 200));
        System.out.println(moneylender.kill("Henrique"));
    }
}
