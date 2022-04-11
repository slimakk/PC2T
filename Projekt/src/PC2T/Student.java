package PC2T;

import java.util.ArrayList;
import java.util.List;

/**
 *Hlavna trieda definujuca zakladne parametre a funkcie studentov
 **/
public abstract class Student {
    private int id;
    private String meno;
    private String priezvisko;
    protected int[] datum = new int[3];
    protected List<Integer> znamky = new ArrayList<>();
    private double priemer;

    /**
     *Setter pre ID
     */
    public void setID(int id) {
        this.id = id;
    }
    /**
     *Setter pre meno a priezvisko
     */
    public void setMeno(String meno, String priezvisko)
    {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }
    /**
     * *Setter pre datum
     */
    public void setDatum (int rok, int mesiac, int den)
    {
        this.datum[0] = den;
        this.datum[1] = mesiac;
        this.datum[2] = rok;
    }
    /**
     * Getter pre datum
     */
    public int[] getDatum()
    {
        return this.datum;
    }
    /**
     * Getter pre meno
     */
    public String getMeno()
    {
        return this.meno;
    }
    /**
     * Getter pre priezvisko
     */
    public String getPriezvisko()
    {
        return this.priezvisko;
    }
    /**
     * Getter pre ID
     */
    public int getId()
    {
        return this.id;
    }
    /**
     * Metoda na pridanie znamky studentovi - vyuziva ArrayList
     */
    public void addZnamka(int znamka)
    {
        //Kontroluje ci je znamka z rozsahu 1 az 5
        if(znamka >= 1 && znamka <= 5)
        {
            this.znamky.add(znamka);
            setPriemer();
        }
        else
            System.out.println("Zla znamka");
    }
    /**
     * Getter pre ArrayList znamok
     */
    public List<Integer> getZnamky() {
        return this.znamky;
    }
    /**
     * Metoda na priamy vypocet priemeru studenta
     */
    public void setPriemer() {
        this.priemer = 0;
        for (var znamka : this.znamky)
        {
            this.priemer += znamka;
        }
        this.priemer = this.priemer / this.znamky.size();
    }
    /**
     * Getter pre priemer studenta
     */
    public double getPriemer() {
        return this.priemer;
    }
    /**
     * Metoda abilita - implementacia sa lisi od typu studenta
     */
    abstract void Abilita();
    /**
     * Pretypovana metoda toString pre vypis studentov
     */
    @Override
    public String toString()
    {
        String datum = getDatum()[0] +"."+getDatum()[1]+"."+getDatum()[2];
        return "ID: "+getId()+" Meno: " + getMeno() + " Priezvisko: " + getPriezvisko() + " Datum narodenia " + datum + " Priemer: " + getPriemer();
    }
    /**
     * Metoda ktora vrati typ studia - lisi sa podla studenta
     */
    abstract String getTypeOfStudium();
}