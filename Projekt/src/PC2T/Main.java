package PC2T;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean run = true;
        int volba;
        int typ;
        int ID;
        int grade;
        Databaza studenti = new Databaza();
        Scanner sc = new Scanner(System.in);
        while(run)
        {
            System.out.println("Vyber moznost:");
            System.out.println("1 - Pridat studenta\n2 - Zadat znamku\n3 - Vyhodit studenta");
            System.out.println("4 - Najst studenta\n5 - Spustit abilitu studenta\n6 - Vypis studentov\n7 - Studijny priemer");
            System.out.println("8 - Pocet studentov\n9- Nacitanie udajov zo suboru\n10 - Ulozenie udajov do suboru\n11 - Ukoncenie programu");
            volba = ValidInput.OnlyInteger(sc);
            switch(volba)
            {
                case 1:
                    studenti.setStudent();
                    break;
                case 2:
                    System.out.println("Zadaj ID studenta");
                    ID = ValidInput.OnlyInteger(sc);
                    System.out.println("Zadaj pozadovanu znamku");
                    grade = ValidInput.OnlyInteger(sc);
                    if(studenti.addZnamku(ID,grade))
                        System.out.println("Znamka bola uspesne pridana");
                    else
                        System.out.println("Zadany student neexistuje");
                    break;
                case 3:
                    System.out.println("Zadaj ID studenta");
                    ID = ValidInput.OnlyInteger(sc);
                    if(studenti.VyhodStudenta(ID))
                        System.out.println("Student bol prepusteny zo studia");
                    else
                        System.out.println("Zadany student neexistuje");
                    break;
                case 4:
                    System.out.println("Zadaj ID studenta");
                    ID = ValidInput.OnlyInteger(sc);
                    System.out.println(studenti.VypisStudenta(ID));
                    break;
                case 5:
                    System.out.println("Zadaj ID studenta");
                    ID = ValidInput.OnlyInteger(sc);
                    studenti.getStudent(ID).Abilita();
                    break;
                case 6:
                    studenti.SortStudent();
                    break;
                case 7:
                    studenti.ObecnyPriemer();
                    break;
                case 8:
                    System.out.println("Technicky odbor: " + studenti.PocetStudentov()[0] + " studentov\nHumanitny odbor: " + studenti.PocetStudentov()[1] +
                            " studentov\nKombinovany odbor: " + studenti.PocetStudentov()[2] );
                    break;
                case 9:
                    System.out.println("1 - Nacitanie databazy zo suboru\n2 - Nacitanie databazy z SQL");
                    typ = ValidInput.OnlyInteger(sc);
                    if(typ == 1)
                        //nacitanie zo suboru
                        DbFile.LoadFromTXT("databaza.txt",studenti);
                    else
                        System.out.println("Not implemented");
                    break;
                case 10:
                    System.out.println("1 - Ulozenie databazy do suboru\n2 - Ulozenie databazy do SQL");
                    typ = ValidInput.OnlyInteger(sc);
                    if(typ == 1)
                        DbFile.zapisDoTXT(studenti,"databaza.txt");
                    else
                        System.out.println("Not implemented");
                    break;
                case 11:
                    run = false;
                    break;
            }
        }
    }
}
