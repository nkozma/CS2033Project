package CS2033;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		//testTalley("Jeffery"); //Talley functioning as intended
		//testPeriod("John", "P3a", "SCI3433"); //Period is working as intended
		//testOnCaller("John"); //OnCaller and its reader are working as intended
		//testRoster(); //Roster is working properly, needs a method to fill OR a filler
		Assigner A1= new Assigner();
		System.out.println(A1);
	}
	
	private static void testTalley(String name)
	{
		Talley t=new Talley(name);
		System.out.println(name+" Hours:"+t.getHours());
		while(!(t.isOverQuota()))
		{
		t.incrementHours();
		System.out.println("Updated Hours:"+t.getHours());
		}
		t.updateHours();
	}
	
	private static void testPeriod(String name, String section, String Class)
	{
		Period p=new Period(name, section, Class);
		System.out.println(p);
	}
	
	private static void testOnCaller(String name)
	{
		OnCaller t1=new OnCaller(name);
		System.out.println(t1);
	}
	
	private static void testRoster()
	{
		Roster r1=new Roster();
		Ireader fill=new ExcelIO("data/CS2033template.xlsx", "Schedule");
		ArrayList <String> onCallers=fill.readField("Name");
		System.out.println(onCallers);
		for(int i=1; i<onCallers.size();i++) {
		r1.addTeacher(new OnCaller(onCallers.get(i)));
		}
		System.out.printf("\n---------------------------------\nTeachers who work at Colonel Gray:\n---------------------------------\n"+r1);
	}
}