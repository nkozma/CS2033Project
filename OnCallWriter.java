package project;

import java.util.ArrayList;

public class OnCallWriter {
	IProcessor writer;
	
	public OnCallWriter(String path, String sheet)
	{
		writer = new ExcelIO(path, sheet);
	}
	
	public void UpdateSheet(Roster r) {
		ArrayList<Teacher> roster = r.getTeacherList();
		
		for(Teacher teacher: roster) {
			ArrayList<Period> taught = teacher.getTaught();
			for(int i=0;i<taught.size();i++) {
				writer.write(taught.get(i).getTeacher(), taught.get(i).getPeriodSection(), teacher.getID());
			}
		}
	}
}
