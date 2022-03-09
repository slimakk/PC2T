package PC2T;

public class Test {

    public static void main(String[] args) {
        Zbozi[] tovar = new Zbozi[4];
        tovar[0] = new Potravina("Rohlik", 1.5,1);
        tovar[1] = new Naradi("Klieste", 278.0, 24);
        tovar[2] = new Potravina("Chleba", 20.8, 6);
        tovar[3] = new Potravina("Jablko", 51.0,20);
        for(int i = 0; i < tovar.length;i++)
        {
            if(tovar[i] instanceof Naradi)
                System.out.printf("%s cena: %.2f zaruka: %d %s%n",tovar[i].getNazovZbozi(),tovar[i].getCena(),((Naradi) tovar[i]).getZaruka(),tovar[i].getJednotka());
            else if(tovar[i] instanceof Potravina)
                System.out.printf("%s cena: %.2f trvanlivost: %d %s%n",tovar[i].getNazovZbozi(),tovar[i].getCena(),((Potravina) tovar[i]).getTrvanlivost(),tovar[i].getJednotka());
        }

    }
}
