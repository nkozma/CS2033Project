package CS2033;

import java.util.ArrayList;

public class OnCallReader {
	private Ireader reader1;
	private Ireader reader2;
	
	OnCallReader(String path, String sheet1, String sheet2)
	{
		reader1=new ExcelIO(path, sheet1);
		reader2=new ExcelIO(path, sheet2);
	}
	
	public ArrayList<Period> getTaught(String name, String[] periodNames)
	{
		ArrayList<Period> taught=new ArrayList<Period>();
		for(int i=0; i<periodNames.length;i++)
		{
			taught.add(new Period(name,periodNames[i],reader1.read(name, periodNames[i])));
		}
		return taught;
	}
	
	public boolean[] getAbsent(String name, String periodNames [])
	{
		String readVal;
		boolean absent[]= {false,false,false,false,false,false};
		for(int i=0; i<periodNames.length; i++)
		{
		readVal=reader2.read(name, periodNames[i]);
		if (!(readVal.equals("P")||readVal.equals("p")))
		{
			absent[i]=true;
		}
		}
		return absent;
	}
}
