package PC2T;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean run = true;
        int volba;
        int ID;
        Databaza studenti = new Databaza();
        Scanner sc = new Scanner(System.in);
        while(run)
        {
            System.out.println("Vyber moznost:");
            System.out.println("1 - Pridat studenta\n2 - Zadat znamku\n3 - Vyhodit studenta");
            System.out.println("4 - Najst studenta\n5 - Spustit abilitu studenta\n6 - Vypis studentov\n7 - Studijny priemer");
            System.out.println("8 - Pocet studentov\n9- Nacitanie udajov zo suboru\n10 - Ulozenie udajov do suboru");
            volba = sc.nextInt();
            switch(volba)
            {
                case 1:
                    studenti.setStudent();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Zadaj ID studenta");
                    ID = sc.nextInt();
                    if(studenti.vyhodStudenta(ID))
                        System.out.println("Student bol prepusteny zo studia");
                    else
                        System.out.println("Zadany student neexistuje");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
            }
        }
    }
}
