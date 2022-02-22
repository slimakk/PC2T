package com.company;

import java.util.Scanner;

public class DatabaseOperation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        database[] Zamestnanci= new database[3];
        for(int i =0; i < Zamestnanci.length;i++)
        {
            System.out.println("Zadaj meno a rok narodenia");
            String meno = sc.nextLine();
            int rok = Integer.parseInt(sc.nextLine());
            Zamestnanci[i]=new database(meno, rok,0);
        }
        System.out.println("Zadaj maximalnu vysku uvazku");
        database.maxUvazek(Double.parseDouble(sc.nextLine()));
        for(;;) {
            System.out.println("Zadaj index osoby a vysku uvazku");
            int index = sc.nextInt();
            int uvazok = sc.nextInt();
            System.out.println(Zamestnanci[index].getMeno());
            System.out.println(Zamestnanci[index].getRokNarozeni());
            if (Zamestnanci[index].kontrolaUvazku(uvazok)) {
                System.out.println(Zamestnanci[index].getVyskaUvazku());
            }
            else
            {
                System.out.println("Bol dosiahnuty maximalny uvazok");
            }
        }
    }
}
