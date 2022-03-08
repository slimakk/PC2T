package PC2T;

public class Naradi extends Zbozi{
    private int zaruka;
    public String getJednotka(){
        return "mesiacov";
    }
    public Naradi(String nazov, double cena,int warr)
    {
        super(nazov,cena);
        this.zaruka = warr;
    }
    public void setZaruka(int zaruka)
    {
        this.zaruka = zaruka;
    }
    public int getZaruka()
    {
        return zaruka;
    }
}
