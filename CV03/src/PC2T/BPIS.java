package PC2T;

public class BPIS implements Predmet{
    public String getNazovPredmetu() {
        return BPC2.class.getSimpleName();
    }
    public int getPocetBodov() {
        return pocetBodov;
    }
    public boolean checkZapocet() {
        if(pocetBodov >= minBody)
        {
            System.out.println("Splnate podmienky na zapocet");
            return true;
        }
        else
        {
            System.out.println("Nesplnate podmienky na zapocet");
            return false;
        }
    }
}
