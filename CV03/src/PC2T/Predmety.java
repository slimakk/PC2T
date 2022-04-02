package PC2T;

public abstract class Predmety implements Predmet{
    public int pocetBodov;
    @Override
    public String getNazovPredmetu() {
        return this.getClass().getSimpleName();
    }
    @Override
    public int getPocetBodov() {
        return pocetBodov;
    }
    public abstract boolean checkZapocet();
}
