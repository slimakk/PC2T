import java.util.Scanner;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	


	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze();
		String jmeno;
		float prumer;
		int volba;
		boolean run=true;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho studenta");
			System.out.println("2 .. nastaveni prumeru studenta");
			System.out.println("3 .. vypis informace o studentovi");
			System.out.println("4 .. ukonceni aplikace");
			System.out.println("5 .. vypis vsetkych studentov");
			System.out.println("6 .. vymazanie studenta");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					mojeDatabaze.setStudent();
					break;
				case 2:
					System.out.println("Zadejte meno a prumer studenta");
					jmeno=sc.next();
					prumer =sc.nextFloat();
					mojeDatabaze.setPrumer(jmeno,prumer);
					break;
				case 3:
					System.out.println("Zadejte meno studenta");
					jmeno=sc.next();
					Student info=mojeDatabaze.getStudent(jmeno);
					System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
				case 4:
					run=false;
					break;
				case 5:
					mojeDatabaze.vypisStudentov();
					break;
				case 6:
					System.out.println("Zadaj meno studenta");
					jmeno=sc.next();
					if(mojeDatabaze.zmazStudenta(jmeno))
						System.out.println("Student "+jmeno+" bol vymazany");
					else
						System.out.println("Zadany student neexistuje");
					break;
			}
			
		}
	}

}
