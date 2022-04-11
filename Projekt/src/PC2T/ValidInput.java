package PC2T;

import java.util.Scanner;
/**
 * Trieda obsahuje metody na kontrolu zadavanych vstupov a zachytavanie vynimiek
 */
public class ValidInput {
    /**
     *  Metoda osetruje vstup tak, aby uzivatel zadal len cele cislo
     */
    public static int OnlyInteger(Scanner sc)
    {
        int number;
        try
        {
            number = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Zly vstup, zadaj len cele cislo");
            sc.nextLine();
            number = OnlyInteger(sc);
        }
        return number;
    }
    /**
     * Metoda osetruje vstup tak, aby uzivatel zadal datum v spravnom formate
     * Vyuziva metodu CorrectLenght a zachytava jej vynimky
     * Vracia int[] datum
     */
    public static int[] ValidDatum(Scanner sc)
    {
        int[] datum;
        try
        {
            String[] dat =sc.next().split("\\.");
            datum = ValidInput.CorrectLenght(dat);
        }
        catch (DateExceptions e) {
            System.out.println(e.getMessage());
            System.out.println("Zadaj znova");
            sc.nextLine();
            datum = ValidDatum(sc);
        }
        return datum;
    }
    /**
     *Metoda kotroluje, ci zadany datum splna podmienky:
     *  -dlzka String[] == 3, ak nie vyhodi vynimku DateExceptions
     *      -dlzka poslenej polozky v String[] (rok) >4 -> max rok 9999, inak vynimka DateExceptions
     * Nasledne je String[] prevedeny na int[] a prebehne kontrola dalsich podmienok:
     *  - prva polozka (den) v int[] v rozsahu 1 <= x <= 31, inak vynimka DateExceptions
     *      - druha polozka (mesiac) v int[] v rozsahu 1 <= x <= 12, inak vynimka DateExceptions
     * Ak su podmienky splnene, metoda vracia int[] datum
     */
    public static int[] CorrectLenght(String [] dat) throws DateExceptions
    {
        int[] datum = new int[3];
        if(dat.length != 3)
            throw new DateExceptions("Zle zadany datum - chyba rok, mesiac alebo den");
        if(dat[2].length() > 4)
            throw new DateExceptions("Neplatny rok");
        for(int i = 0; i < 3 ; i++)
        {
            datum[i] = Integer.parseInt(dat[i]);
        }
        if(datum[0] < 1 || datum[0] > 31)
            throw new DateExceptions("Neplatny den");
        else if(datum[1] < 1 || datum[1] > 12)
            throw new DateExceptions("Neplatny mesiac");
        return datum;
    }
    /**
     * Definicia specifickej DateException pre potreby kontroly spravneho datumu
     */
    public static class DateExceptions extends java.lang.Exception
    {
        public DateExceptions(String msg)
        {
            super(msg);
        }
    }
}