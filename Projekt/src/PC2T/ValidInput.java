package PC2T;

import java.util.Scanner;

public class ValidInput {
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
    public static int[] ValidDatum(Scanner sc)
    {
        int[] datum = new int[3];
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
    public static class DateExceptions extends java.lang.Exception
    {
        public DateExceptions(String msg)
        {
            super(msg);
        }
    }
}