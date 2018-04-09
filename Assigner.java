package CS2033;

import java.util.ArrayList;
import java.util.Arrays;

public class Assigner {
	
	private int absentPeriods[]=new int[6];
	private ArrayList<ArrayList<Period>> absent=new ArrayList<ArrayList<Period>>();
	private static final String[] PeriodNames= {"P1","P2","P3a","P3b","P4","P5"};
	private Roster availableTeachers;
	
	public Assigner()
	{
		AssignerReader reader=new AssignerReader("data/CS2033template.xlsx","Week");
	}
	
	public Assigner(Roster r)
	{
		availableTeachers = r;
		AssignerReader reader=new AssignerReader("data/CS2033template.xlsx","Week");
		absentPeriods=reader.absentPeriods(PeriodNames);
		
	}
	
	private void assignTeacher() {
		for(int i = 0; i<availableTeachers.size();i++) {
			Teacher currentTeacher = availableTeachers.getTeacher(i);
			for(int j = 0; j<PeriodNames.length; j++) {
				if(currentTeacher.isFreePeriod(PeriodNames[j])) {
					for(int k = 0; k<availableTeachers.size();k++) {
						if availableTeachers.
					}
				}
				
			}
		}
	}
	
	public String toString()
	{
		return String.format(Arrays.toString(absentPeriods));
	}
}
