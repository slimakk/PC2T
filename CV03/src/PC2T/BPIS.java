package PC2T;

import java.util.Scanner;

public class BPIS implements Predmet{
    private int pocetBodov = 0;
    public String getNazovPredmetu() {
        return BPIS.class.getSimpleName();
    }
    public int getPocetBodov() {
        return pocetBodov;
    }
    public boolean checkZapocet() {
        System.out.println("Udel zapocet - 0 alebo 1");
        Scanner sc = new Scanner(System.in);
        int zapocet = sc.nextInt();
        if(zapocet == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
