package PC2T;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Databaza {
    private Map<Integer, Student> prvkyDatabaze;
    private Scanner sc;
    public Databaza()
    {
        prvkyDatabaze = new HashMap<>();
        sc = new Scanner(System.in);
    }
    public void setStudent()
    {
        System.out.println("Zadaj meno a priezvisko");
        String meno = sc.next();
        String priezvisko = sc.next();
        System.out.println("Zadaj datum narodenia");
        String[] dat = sc.next().split(".");
        int[] datum = new int[3];
        for(int i = 0; i < dat.length; i++)
        {
            datum[i] = Integer.parseInt(dat[i]);
        }
        System.out.println("Zadaj typ studia");
        int volba = sc.nextInt();
        int id = prvkyDatabaze.size()+1;
        switch(volba)
        {
            case 1:
                prvkyDatabaze.put(id,new Tech(meno,priezvisko,id,datum[0],datum[1],datum[2] ) );
                break;
            case 2:
                prvkyDatabaze.put(id,new Hum(meno,priezvisko,id,datum[0],datum[1],datum[2] ) );
                break;
            case 3:
                prvkyDatabaze.put(id,new Tech(meno,priezvisko,id,datum[0],datum[1],datum[2] ) );
                break;
        }
    }
}
