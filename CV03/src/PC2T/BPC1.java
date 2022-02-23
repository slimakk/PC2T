package PC2T;

import java.util.Scanner;

public class BPC1 implements Predmet
{
    private int pocetBodov =0;
    public String getNazovPredmetu() {
        return BPC1.class.getSimpleName();
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
    public int setCvicenieBody()
    {
        Scanner sc = new Scanner(System.in);
        int body = 0;
        String key;
        for(;;)
        {
            System.out.println("Zadaj pocet bodov za cvicenie (0-20) alebo ukonci x");
            key = sc.nextLine();
            if(key.compareTo("x")!= 0)
            {
                body = Integer.parseInt(key);
                if(pocetBodov + body <= 20)
                {
                    pocetBodov += body;
                }
                else
                    System.out.println("Bol dosiahnuty maximalny pocet bodov");
            }
            else
            {
                break;
            }
        }
        return pocetBodov;
    }
    public int setSkuskaBody()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadaj pocet bodov za skusku");
        int body =sc.nextInt();
        if(body <= 80)
            pocetBodov += body;
        else
            System.out.println("Zadany pocet bodov presahuje maximum");
        return pocetBodov;
    }
}
