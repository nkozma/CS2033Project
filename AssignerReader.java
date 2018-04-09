package CS2033;

import java.util.ArrayList;

public class AssignerReader {
	private Ireader reader;
	
	public AssignerReader(String path, String sheet)
	{
		reader=new ExcelIO(path, sheet);
	}
	
	public int[] absentPeriods(String periodNames[])
	{
		int periodsAbsent[]= {0,0,0,0,0,0};
		ArrayList<String> periodData;
		
		for(int i=0; i<periodNames.length; i++)
		{
		periodData=reader.readField(periodNames[i]);
		for(int j=0;j<periodData.size();j++)
		{
			if(periodData.get(j).equals("X")||periodData.get(j).equals("x"))
			{
				periodsAbsent[i]++;
			}
		}
		}
		return periodsAbsent;
	}
	
	public ArrayList<AbsentPeriod> [] absentPeriodsList(String periodNames[])
	{
		ArrayList<AbsentPeriod> [] absents=(ArrayList<AbsentPeriod>[]) new ArrayList[6];
		
		for(int i=0; i<absents.length; i++)
		{
			absents[i]=new ArrayList<AbsentPeriod>();
		}
		
		ArrayList<String> teachers=reader.readField("Name");
		ArrayList<String> periodData=new ArrayList<String>();
		for(int i=1; i<teachers.size(); i++)
		{
			periodData=reader.readRow(teachers.get(i));
			for(int j=1; j<periodData.size(); j++)
			{
				if(periodData.get(j).equals("X")||periodData.get(j).equals("x"))
				{
					absents[j-1].add(new AbsentPeriod(teachers.get(i),periodNames[j-1],"Absent"));
				}
			}
		}
		return absents;
	}
}