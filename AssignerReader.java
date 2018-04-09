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
	public ArrayList<ArrayList<Period>> absentPeriodsList(String periodNames[])
	{
		ArrayList<ArrayList<Period>> absent=new ArrayList<ArrayList<Period>>();
		ArrayList<String> periodData;
		
	}
}
