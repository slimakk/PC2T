package PC2T;

import java.util.ArrayList;
import java.util.List;

public abstract class Student {
    private int id;
    private String meno;
    private String priezvisko;
    protected int[] datum = new int[3];
    protected List<Integer> znamky = new ArrayList<>();
    private double priemer;
    public void setID(int id) {
        this.id = id;
    }
    public void setMeno(String meno, String priezvisko)
    {
        this.meno = meno;
        this.priezvisko = priezvisko;
    }
    public void setDatum (int rok, int mesiac, int den)
    {
        this.datum[0] = den;
        this.datum[1] = mesiac;
        this.datum[2] = rok;
    }
    public int[] getDatum()
    {
        return datum;
    }
    public String getMeno()
    {
        return this.meno;
    }
    public String getPriezvisko()
    {
        return this.priezvisko;
    }
    public int getId()
    {
        return this.id;
    }
    public void addZnamka(int znamka)
    {
        if(znamka >= 1 && znamka <= 5)
            this.znamky.add(znamka);
        else
            System.out.println("Zla znamka");
    }

    public double getPriemer() {
        for (var znamka : this.znamky)
        {
            this.priemer += znamka;
        }
        this.priemer = priemer / this.znamky.size();
        return this.priemer;
    }

    abstract void Abilita();
    @Override
    public abstract String toString();
    abstract String getTypeOfStudium();
}
