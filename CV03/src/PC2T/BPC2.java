package PC2T;

import java.util.Scanner;

public class BPC2 implements Predmet{
    private int pocetBodov =0;
    public String getNazovPredmetu() {
        return BPC2.class.getSimpleName();
    }
    public int getPocetBodov() {
        return pocetBodov;
    }
    public boolean checkZapocet() {
        if(pocetBodov >= minBody)
        {
            System.out.println("Splnate podmienky na zapocet");
            return true;
        }
        else
        {
            System.out.println("Nesplnate podmienky na zapocet");
            return false;
        }
    }
    public int setProjektBody()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadaj pocet bodov za projekt");
        int body =sc.nextInt();
        if(body <= 30)
            pocetBodov += body;
        else
            System.out.println("Zadany pocet bodov presahuje maximum");
        return pocetBodov;
    }
    public int setTestBody()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadaj pocet bodov za polsemestralny test");
        int body =sc.nextInt();
        if(body <= 20)
            pocetBodov += body;
        else
            System.out.println("Zadany pocet bodov presahuje maximum");
        return pocetBodov;
    }
    public int setSkuskaBody()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadaj pocet bodov za skusku");
        int body =sc.nextInt();
        if(body <= 50)
            pocetBodov += body;
        else
            System.out.println("Zadany pocet bodov presahuje maximum");
        return pocetBodov;
    }
}
