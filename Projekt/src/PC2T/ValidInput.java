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
}
