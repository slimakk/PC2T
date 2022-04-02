package com.company;

public class database {
    public String Meno;
    int rokNarozeni;
    double vyskaUvazku;
    static double maxUvazok = 1;
    database(String meno, int rok,double uvazok)
    {
        Meno=meno;
        rokNarozeni=rok;
        vyskaUvazku=uvazok;
    }
    public String getMeno() {
        return Meno;
    }
    public int getRokNarozeni() {
        return rokNarozeni;
    }
    public double getVyskaUvazku() {
        return vyskaUvazku;
    }
    public static double maxUvazek(double maxUvazek)
    {
        return maxUvazok=maxUvazek;
    }
    public boolean kontrolaUvazku (double uvazok)
    {
        if(uvazok+vyskaUvazku > maxUvazok)
        {
            return false;
        }
        else
        {
            vyskaUvazku+=uvazok;
            return true;
        }
    }
}
