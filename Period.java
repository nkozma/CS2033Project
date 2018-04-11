package CS2033;

public class Period {
	private String normalTeacherName;
	private String periodSection;
	private String className;
	
	public Period(String name, String section, String Class)
	{
		normalTeacherName=name;
		periodSection=section;
		className=Class;
	}
	
	public void setClassName(String className) {this.className=className;}
	public void setPeriodSection(String periodSection) {this.periodSection=periodSection;}
	public void setNormalTeacher(String normalTeacherName) {this.normalTeacherName=normalTeacherName;}
	
	
	public String getClassName(){return className;}
	public String getTeacher() {return normalTeacherName;}
	public String getPeriodSection() {return periodSection;}
	
	public String toString()
	{
		return String.format("Regular Teacher: %s\nCourse period: %s\nClass Code: %s\n", normalTeacherName, periodSection, className);
	}
}