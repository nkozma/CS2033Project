package CS2033;

public class AbsentPeriod extends Period{
	
	private String sub;
	
	public AbsentPeriod (String name, String section, String className)
	{
		super(name, section, className);
	}
	
	public void setSub(String name) {sub=name;}
	public String getTeacher() {return sub;}
}
