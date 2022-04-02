package PC2T;

public abstract class Zbozi {
    private String nazovZbozi;
    private double cenaBezDPH;
    private static double DPH = 0.21;
    public abstract String getJednotka();
    public Zbozi (String nazov, double cena)
    {
        setNazovZbozi(nazov);
        setCena(cena);
    }
    public void setCena(double cena)
    {
        this.cenaBezDPH = cena;
    }
    public double getCena()
    {
        return cenaBezDPH+cenaBezDPH*DPH;
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
