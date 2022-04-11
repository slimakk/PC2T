package PC2T;
/**
 * Trieda studentov humanitneho odboru - dedi z triedy kombinovaneho studia
**/
public class Hum extends Kombi{
    public Hum(String meno, String priezvisko, int ID, int den, int mesiac, int rok)
    {
        super(meno,priezvisko,ID,den,mesiac,rok);
    }
    @Override
    String getTypeOfStudium() {
        return "Humanitne";
    }
    @Override
    public void Abilita() {
        Zverokruh();
    }
}