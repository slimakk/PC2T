package PC2T;

import java.util.Arrays;

public class Kombi extends Student{
    public Kombi(String meno, String priezvisko, int ID, int den, int mesiac, int rok)
    {
        setMeno(meno,priezvisko);
        setDatum(rok, mesiac, den);
        setID(ID);
    }

    @Override
    void Abilita() {

    }

    @Override
    String getTypeOfStudium() {
        return "Kombinovane";
    }
}
