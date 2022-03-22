import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Databaze {
	public Databaze()
	{
		prvkyDatabaze=new HashMap<>();
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		prvkyDatabaze.put(jmeno,new Student(jmeno,rok));
	}
	
	public Student getStudent(String jmeno)
	{
		for (Student student : prvkyDatabaze.values())
		{
			if(student.getJmeno().equals(jmeno))
				return student;
		}
		return null;
	}
	
	public boolean setPrumer(String jmeno, float prumer)
	{
		if(prvkyDatabaze.get(jmeno) == null)
		{
			return false;
		}
		prvkyDatabaze.get(jmeno).setStudijniPrumer(prumer);
		return true;
	}
	public void vypisStudentov()
	{
		for(Student student : prvkyDatabaze.values())
		{
			System.out.println("Jmeno: " + student.getJmeno());
		}
	}
	public boolean zmazStudenta(String jmeno)
	{
		if(prvkyDatabaze.get(jmeno) == null)
		{
			return false;
		}
		prvkyDatabaze.remove(jmeno);
		return true;
	}
	private Scanner sc;
	private Map<String,Student> prvkyDatabaze;
}