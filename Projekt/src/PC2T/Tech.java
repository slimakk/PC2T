package PC2T;

import java.util.SortedMap;

public class Tech extends Student{

    public Tech(String meno, String priezvisko, int ID, int den, int mesiac, int rok)
    {
        setMeno(meno,priezvisko);
        setDatum(rok, mesiac, den);
        setID(ID);
    }
    @Override
    public void Abilita() {
        int[] datum = getDatum();
        if(datum[2] % 4 == 0)
        {
            System.out.println("Rok narodenia je prestupny rok");
        }
        else
        {
            System.out.println("Rok narodenia nie je prestupny rok");
        }
    }
}
