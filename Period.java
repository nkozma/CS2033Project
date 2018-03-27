package project.group2.system.njk;

public class Period {
	String normalTeacherName;
	String periodSection;
	String className;
	public Period(String name, String section, String Class)
	{
		normalTeacherName=name;
		periodSection=section;
		className=Class;
	}
	
	public String getClassName(){return className;}
	public String getTeacher() {return normalTeacherName;}
	public String getPeriodSection() {return periodSection;}
	
	public String toString()
	{
		return String.format("Regular Teacher: %s\nCourse period: %s\nClass Code: %s", normalTeacherName, periodSection, className);
	}
}