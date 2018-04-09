package CS2033;

import java.util.ArrayList;

public class Roster {
	private ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
	
	public void addTeacher(Teacher t) {teacherList.add(t);}
	public Teacher getTeacher(int index) {return teacherList.get(index);}
	public int size() {return teacherList.size();}
	public String toString()
	{
		String printer="";
		for(int i=0; i<teacherList.size();i++)
		{
			printer=printer+teacherList.get(i).toString()+"\n\n";
		}
		return printer;
	}
}