package PC2T;

public abstract class Zbozi {
    private String nazovZbozi;
    private double cenaBezDPH;
    private static double DPH = 1.21;
    abstract String getJednotka();
    public Zbozi (String nazov, double cena)
    {
        this.nazovZbozi = nazov;
        this.cenaBezDPH = cena;
    }
    public void setCena(double cena)
    {
        this.cenaBezDPH = cena;
    }
    public double getCena()
    {
        return cenaBezDPH*DPH;
    }
    public void setNazovZbozi(String nazov)
    {
        this.nazovZbozi = nazov;
    }
    public String getNazovZbozi()
    {
        return nazovZbozi;
    }
}
