package PC2T;

public class Potravina extends Zbozi{
    private int trvanlivost;
    public String getJednotka()
    {
        return "dni";
    }
    public Potravina(String nazov,double cena,int trvan)
    {
        super(nazov,cena);
        setTrvanlivost(trvan);
    }
    public void setTrvanlivost(int trvan)
    {
        this.trvanlivost = trvan;
    }
    public int getTrvanlivost()
    {
        return trvanlivost;
    }
}
