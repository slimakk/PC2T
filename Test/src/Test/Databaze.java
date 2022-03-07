package Test;
public class Databaze {
    private String[] databaza;
    public Databaze(int pocetPrvkov)
    {
        databaza = new String[pocetPrvkov];
    }
    public void setMeno(String meno,int index)
    {
        databaza[index]=meno;
    }
    public String getMeno (int index)
    {
        return databaza[index];
    }
}
