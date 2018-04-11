package CS2033;

import java.util.ArrayList;
import java.util.Arrays;

public class Assigner {
	
	private ArrayList<AbsentPeriod> [] absent=(ArrayList<AbsentPeriod>[]) new ArrayList[6];
	private static final String[] PeriodNames= {"P1","P2","P3a","P3b","P4","P5"};
	private ArrayList<OnCaller> remainder=new ArrayList<OnCaller>();
	private ArrayList<Teacher> priority=new ArrayList<Teacher>();
	
	public Assigner()
	{
		AssignerReader reader=new AssignerReader("data/CS2033template.xlsx","Week");
		absent=reader.absentPeriodsList(PeriodNames);
	}
	
	public void Assignment()
	{
		ArrayList<Teacher> subPriority=new ArrayList<Teacher>();
		ArrayList<OnCaller> subRem=new ArrayList<OnCaller>();
		
		for(int i=0; i<PeriodNames.length; i++)
		{
			if(!(absent[i].isEmpty()))
			{
				//subPriority=freeTeacher(priority,i);
				subRem=freeOnCaller(remainder,i);
				
				for(int j=0;j<absent[i].size();j++)
				{
				}
			}
		}
	}
	
	private ArrayList<Teacher> freeTeacher(ArrayList<Teacher> r1, int check)
	{
		ArrayList<Teacher> subr1=new ArrayList<Teacher>();
		
		for(int i=0; i<r1.size(); i++)
		{
			if(r1.get(i).isFreePeriod(PeriodNames[check])) {
				subr1.add(r1.get(i));
			}
		}
		
		return subr1;
	}
	
	public ArrayList<OnCaller> freeOnCaller(ArrayList<OnCaller> r1, int check)
	{
		ArrayList<OnCaller> subr1=new ArrayList<OnCaller>();
		
		for(int i=0; i<r1.size(); i++)
		{
			if(r1.get(i).isFreePeriod(PeriodNames[check])) {
				subr1.add(r1.get(i));
			}
		}
		
		return subr1;
	}
	
	public String toString()
	{
		for(int i=0; i<absent.length; i++)
		{
			for(int j=0; j<absent[i].size(); j++)
			{
				System.out.println(absent[i].get(j));
			}
		}
		return String.format("\n");
	}
}
