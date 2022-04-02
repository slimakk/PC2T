package PC2T;

public class Test {

    public static void main(String[] args) {
        BPC1 predmet = new BPC1();
        BPC2 predmet1 = new BPC2();
        BPIS predmet2 = new BPIS();
        System.out.println("Predmet: "+predmet.getNazovPredmetu());
        predmet.setCvicenieBody();
        System.out.println(predmet.getPocetBodov());
        System.out.println("Zapocet:");
        if(predmet.checkZapocet())
        {
            System.out.println("Bol udeleny zapocet");
            predmet.setSkuskaBody();
        }
        else
            System.out.println("Nebol udeleny zapocet");
        System.out.println("Vysledny pocet bodov: "+ predmet.getPocetBodov());
        System.out.println("Predmet: "+predmet1.getNazovPredmetu());
        predmet1.setProjektBody();
        predmet1.setTestBody();
        System.out.println(predmet1.getPocetBodov());
        System.out.println("Zapocet:");
        if(predmet1.checkZapocet())
        {
            System.out.println("Bol udeleny zapocet");
            predmet1.setSkuskaBody();
        }
        else
            System.out.println("Nebol udeleny zapocet");
        System.out.println("Vysledny pocet bodov: "+ predmet1.getPocetBodov());
        System.out.println("Predmet "+predmet2.getNazovPredmetu());
        if(predmet2.checkZapocet())
        {
            System.out.println("Bol udeleny zapocet");
        }
        else
            System.out.println("Nebol udeleny zapocet");

    }
}
