package PC2T;

public abstract class Student {
    private int id;
    private String meno;
    private String priezvisko;
    protected int[] datum = new int[3];

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
    abstract void Abilita();
}
