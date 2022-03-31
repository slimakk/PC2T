package PC2T;

import java.util.*;

public class Databaza {
    private TreeMap<Integer, Student> prvkyDatabaze;
    private Scanner sc;
    public Databaza()
    {
        prvkyDatabaze = new TreeMap<>();
        sc = new Scanner(System.in);
    }
    public void setStudent()
    {
        System.out.println("Zadaj meno a priezvisko");
        String meno = sc.next();
        String priezvisko = sc.next();
        System.out.println("Zadaj datum narodenia");
        String[] dat = sc.next().split("\\.");
        int[] datum = new int[3];
        for(int i = 0; i < dat.length; i++)
        {
            datum[i] = Integer.parseInt(dat[i]);
        }
        System.out.println("Zadaj typ studia: 1 - Technicke; 2 - Humanitne; 3 - Kombinovane");
        int volba = ValidInput.OnlyInteger(sc);
        int id ;
        if(prvkyDatabaze.isEmpty())
            id = 1;
        else
            id = prvkyDatabaze.lastKey()+1;
        switch(volba)
        {
            case 1:
                prvkyDatabaze.put(id,new Tech(meno,priezvisko,id,datum[0],datum[1],datum[2] ) );
                break;
            case 2:
                prvkyDatabaze.put(id,new Hum(meno,priezvisko,id,datum[0],datum[1],datum[2] ) );
                break;
            case 3:
                prvkyDatabaze.put(id,new Kombi(meno,priezvisko,id,datum[0],datum[1],datum[2] ) );
                break;
        }
    }
    public Student getStudent(int ID)
    {
        for(Student student : prvkyDatabaze.values())
        {
            if(prvkyDatabaze.get(ID).equals(ID))
                return student;
        }
        return null;
    }
    public boolean VyhodStudenta(int ID)
    {
        if(prvkyDatabaze.get(ID) == null)
            return false;
        prvkyDatabaze.remove(ID);
        return true;
    }
    public boolean addZnamku(int ID, int znamka)
    {
        if(prvkyDatabaze.get(ID) == null)
            return false;
        prvkyDatabaze.get(ID).addZnamka(znamka);
        return true;
    }
    public String VypisStudenta(int ID)
    {
        if(prvkyDatabaze.containsKey(ID))
        {
            return "Meno: " + prvkyDatabaze.get(ID).getMeno() + " Priezvisko: " + prvkyDatabaze.get(ID).getPriezvisko() +
                    " Datum narodenia: " + Arrays.toString(prvkyDatabaze.get(ID).getDatum()) + " Priemer: " + prvkyDatabaze.get(ID).getPriemer();
        }
        else
            return "Zadany student neexistuje";
    }
    public void SortStudent()
    {
        List<Map.Entry<Integer, Student>> entryList = new ArrayList<Map.Entry<Integer, Student>>(prvkyDatabaze.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Student>>() {
            @Override
            public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
                return o1.getValue().getPriezvisko().compareTo(o2.getValue().getPriezvisko());
            }
        });
        System.out.println("Technicky odbor:");
        for (var value : entryList)
        {
            if(value.getValue().getTypeOfStudium() == "Tech")
                System.out.println(value.getValue());
        }
        System.out.println("Humanitny odbor:");
        for (var value : entryList)
        {
            if(value.getValue().getTypeOfStudium() == "Humanitne")
                System.out.println(value.getValue());
        }
        System.out.println("Kombinovany odbor:");
        for (var value : entryList)
        {
            if(value.getValue().getTypeOfStudium() == "Kombinovane")
                System.out.println(value.getValue());
        }

    }
    public int[] PocetStudentov()
    {
        Set <Integer> kluce = prvkyDatabaze.keySet();
        int[] pocty = new int[3];
        for(int kluc:kluce)
        {
            if(prvkyDatabaze.get(kluc).getTypeOfStudium() == "Tech")
                pocty[0]++;
            else if(prvkyDatabaze.get(kluc).getTypeOfStudium() == "Humanitne")
                pocty[1]++;
            else
                pocty[2]++;
        }
        return pocty;
        //
    }
    public void ObecnyPriemer()
    {
        Set <Integer> keys = prvkyDatabaze.keySet();
        double techPriemer = 0; double humPriemer = 0;
        for(int key:keys)
        {
            if(prvkyDatabaze.get(key).getTypeOfStudium() == "Tech")
                techPriemer+=prvkyDatabaze.get(key).getPriemer();
            else if(prvkyDatabaze.get(key).getTypeOfStudium() == "Humanitne")
                humPriemer+=prvkyDatabaze.get(key).getPriemer();
        }
        techPriemer = techPriemer / PocetStudentov()[0];
        humPriemer = humPriemer / PocetStudentov()[1];
        System.out.println("Technicky odbor: "+techPriemer+"\nHumanitny odbor: "+humPriemer);
    }
}
