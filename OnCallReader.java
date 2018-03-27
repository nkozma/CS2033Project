package project.group2.system.njk;

import java.util.ArrayList;

public class OnCallReader {
	Ireader reader;
	OnCallReader(String path, String sheet)
	{
		reader=new ExcelIO(path, sheet);
	}
	
	public ArrayList<Period> getTaught(String name, String[] periodNames)
	{
		ArrayList<Period> taught=new ArrayList<Period>();
		for(int i=0; i<periodNames.length;i++)
		{
			taught.add(new Period(name,periodNames[i],reader.read(name, periodNames[i])));
		}
		return taught;
	}
}
