package PC2T;

import java.sql.SQLException;
import java.util.*;

public class Databaza {
    private TreeMap<Integer, Student> prvkyDatabaze;
    private Scanner sc;
    public Databaza()
    {
        prvkyDatabaze = new TreeMap<>();
        sc = new Scanner(System.in);
    }

    public TreeMap<Integer, Student> getPrvkyDatabaze() {
        return prvkyDatabaze;
    }

    public void setPrvkyDatabaze(int id, String meno, String priezvisko, int den, int mesiac, int rok, String typ) {
        if(typ.equals("Tech"))
            this.prvkyDatabaze.put(id,new Tech(meno,priezvisko,id,den,mesiac,rok));
        else if(typ.equals("Humanitne"))
            this.prvkyDatabaze.put(id,new Hum(meno,priezvisko,id,den,mesiac,rok));
        else
            this.prvkyDatabaze.put(id,new Kombi(meno,priezvisko,id,den,mesiac,rok));
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
                this.prvkyDatabaze.put(id,new Tech(meno,priezvisko,id,datum[0],datum[1],datum[2]) );
                break;
            case 2:
                this.prvkyDatabaze.put(id,new Hum(meno,priezvisko,id,datum[0],datum[1],datum[2]) );
                break;
            case 3:
                this.prvkyDatabaze.put(id,new Kombi(meno,priezvisko,id,datum[0],datum[1],datum[2]) );
                break;
        }
    }
    public Student getStudent(int ID)
    {
        for(Student student : prvkyDatabaze.values())
        {
            if(prvkyDatabaze.get(ID).getId() == ID)
                return student;
        }
        return null;
    }
    public boolean VyhodStudenta(int ID) {
        if(prvkyDatabaze.get(ID) == null)
            return false;
        this.prvkyDatabaze.remove(ID);
        return true;
    }
    public boolean addZnamku(int ID, int znamka)
    {
        if(prvkyDatabaze.get(ID) == null)
            return false;
        this.prvkyDatabaze.get(ID).addZnamka(znamka);
        return true;
    }
    public String VypisStudenta(int ID)
    {
        if(this.prvkyDatabaze.containsKey(ID))
        {
            return "Meno: " + this.prvkyDatabaze.get(ID).getMeno() + " Priezvisko: " + this.prvkyDatabaze.get(ID).getPriezvisko() +
                    " Datum narodenia: " + Arrays.toString(this.prvkyDatabaze.get(ID).getDatum()) + " Priemer: " + this.prvkyDatabaze.get(ID).getPriemer();
        }
        else
            return "Zadany student neexistuje";
    }
    public void SortStudent()
    {
        List<Map.Entry<Integer, Student>> entryList = new ArrayList<Map.Entry<Integer, Student>>(this.prvkyDatabaze.entrySet());
        entryList.sort((o1, o2) -> o1.getValue().getPriezvisko().compareTo(o2.getValue().getPriezvisko()));
        System.out.println("Technicky odbor:");
        for (var value : entryList)
        {
            if(value.getValue().getTypeOfStudium().equals("Tech"))
                System.out.println(value.getValue());
        }
        System.out.println("Humanitny odbor:");
        for (var value : entryList)
        {
            if(value.getValue().getTypeOfStudium().equals("Humanitne"))
                System.out.println(value.getValue());
        }
        System.out.println("Kombinovany odbor:");
        for (var value : entryList)
        {
            if(value.getValue().getTypeOfStudium().equals("Kombinovane"))
                System.out.println(value.getValue());
        }

    }
    public int[] PocetStudentov()
    {
        Set <Integer> kluce = this.prvkyDatabaze.keySet();
        int[] pocty = new int[3];
        for(int kluc:kluce)
        {
            if(prvkyDatabaze.get(kluc).getTypeOfStudium().equals("Tech"))
                pocty[0]++;
            else if(prvkyDatabaze.get(kluc).getTypeOfStudium().equals("Humanitne"))
                pocty[1]++;
            else
                pocty[2]++;
        }
        return pocty;
    }
    public void ObecnyPriemer()
    {
        Set <Integer> keys = prvkyDatabaze.keySet();
        double techPriemer = 0; double humPriemer = 0;
        for(int key:keys)
        {
            if(prvkyDatabaze.get(key).getTypeOfStudium().equals("Tech"))
                techPriemer+=prvkyDatabaze.get(key).getPriemer();
            else if(prvkyDatabaze.get(key).getTypeOfStudium().equals("Humanitne"))
                humPriemer+=prvkyDatabaze.get(key).getPriemer();
        }
        techPriemer = techPriemer / PocetStudentov()[0];
        humPriemer = humPriemer / PocetStudentov()[1];
        System.out.println("Technicky odbor: "+techPriemer+"\nHumanitny odbor: "+humPriemer);
    }
    public void AddToDB(DbSQL db) throws SQLException {
        db.Connect();
        db.CreateTable();
        Set <Integer> kluce = this.prvkyDatabaze.keySet();
        int i = 0;
        for(int kluc:kluce)
        {
            int id = prvkyDatabaze.get(kluc).getId();
            String name = prvkyDatabaze.get(kluc).getMeno();
            String surname = prvkyDatabaze.get(kluc).getPriezvisko();
            int[] datum = prvkyDatabaze.get(kluc).getDatum();
            String type = prvkyDatabaze.get(kluc).getTypeOfStudium();
            db.AddStudent(id,name,surname,datum,type);
            for(var value:prvkyDatabaze.get(kluc).getZnamky())
            {
                db.AddGrades(id,value,i);
                i++;
            }
        }
        db.Disconnect();
    }
    public void LoadFromDB(DbSQL db, Databaza dat) throws SQLException {
        db.Connect();
        db.LoadStudent(dat);
        Set <Integer> kluce = this.prvkyDatabaze.keySet();
        for(int kluc:kluce)
        {
            db.LoadGrades(kluc,dat);
        }
        db.Disconnect();
    }
}
