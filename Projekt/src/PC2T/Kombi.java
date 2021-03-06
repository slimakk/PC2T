package PC2T;
/**
 * Hlavny typ studenta - implementuje obe specialne ability
 * Trieda dedi z hlavnej triedy Student
 */
public class Kombi extends Student{
    public Kombi(String meno, String priezvisko, int ID, int den, int mesiac, int rok)
    {
        setMeno(meno,priezvisko);
        setDatum(rok, mesiac, den);
        setID(ID);
    }
    /**
     * Metoda zisti, ci je rok narodenia prestupny rok
     */
    public void PrestupnyRok() {
        if(datum[2] % 4 == 0)
        {
            System.out.println("Rok narodenia je prestupny rok");
        }
        else
        {
            System.out.println("Rok narodenia nie je prestupny rok");
        }
    }
    /**
     * Metoda vypise znamenie studenta podla datumu narodenia
     */
    public void Zverokruh() {
        if(((datum[0] >= 21) && (datum[1] == 3)) || ((datum[0] <= 20) && (datum[1] == 4)))
            System.out.println("Znamenie: Baran");
        else if(((datum[0] >= 21) && (datum[1] == 4)) || ((datum[0] <= 20) && (datum[1] == 5)))
            System.out.println("Znamenie: Byk");
        else if(((datum[0] >= 21) && (datum[1] == 5)) || ((datum[0] <= 21) && (datum[1] == 6)))
            System.out.println("Znamenie: Blizenci");
        else if(((datum[0] >= 22) && (datum[1] == 6)) || ((datum[0] <= 22) && (datum[1] == 7)))
            System.out.println("Znamenie: Rak");
        else if(((datum[0] >= 23) && (datum[1] == 7)) || ((datum[0] <= 22) && (datum[1] == 8)))
            System.out.println("Znamenie: Lev");
        else if(((datum[0] >= 23) && (datum[1] == 8)) || ((datum[0] <= 22) && (datum[1] == 9)))
            System.out.println("Znamenie: Panna");
        else if(((datum[0] >= 23) && (datum[1] == 9)) || ((datum[0] <= 22) && (datum[1] == 10)))
            System.out.println("Znamenie: Vahy");
        else if(((datum[0] >= 23) && (datum[1] == 10)) || ((datum[0] <= 22) && (datum[1] == 11)))
            System.out.println("Znamenie: Skorpion");
        else if(((datum[0] >= 23) && (datum[1] == 11)) || ((datum[0] <= 21) && (datum[1] == 12)))
            System.out.println("Znamenie: Strelec");
        else if(((datum[0] >= 22) && (datum[1] == 12)) || ((datum[0] <= 20) && (datum[1] == 1)))
            System.out.println("Znamenie: Kozorozec");
        else if(((datum[0] >= 21) && (datum[1] == 1)) || ((datum[0] <= 19) && (datum[1] == 2)))
            System.out.println("Znamenie: Vodnar");
        else if(((datum[0] >= 20) && (datum[1] == 2)) || ((datum[0] <= 20) && (datum[1] == 3)))
            System.out.println("Znamenie: Byk");
    }
    @Override
    public void Abilita() {
        PrestupnyRok();
        Zverokruh();
    }
    @Override
    String getTypeOfStudium() {
        return "Kombinovane";
    }
}