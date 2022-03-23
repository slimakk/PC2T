package PC2T;

public class Hum extends  Student{

    public Hum(String meno, String priezvisko, int ID, int den, int mesiac, int rok)
    {
        setMeno(meno,priezvisko);
        setDatum(rok, mesiac, den);
        setID(ID);
    }
    @Override
    void Abilita() {

    }
}
