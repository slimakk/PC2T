import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer)
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
	@Override
	public String toString()
	{
		var line = "";
		for(int i = 0; i < prvkyDatabaze.length; i++)
		{
			var student = getStudent(i);
			line += String.format("Meno: "+student.getJmeno() + " rok narodenia: "+student.getRocnik() + " studijny priemer: "+student.getStudijniPrumer() +"\n");
		}
		return line;
	}
	public void zapisDoSuboru()
	{
		var line = "";
		for(int i = 0; i < prvkyDatabaze.length; i++)
		{
			var student = getStudent(i);
			line += String.format("Meno: "+student.getJmeno() + " rok narodenia: "+student.getRocnik() + " studijny priemer: "+student.getStudijniPrumer() +"\n");
		}
		try
		{
			FileWriter zapis = new FileWriter("databaza.txt");
			zapis.write(line);
			zapis.close();
			System.out.println("Uspesny zapis");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}