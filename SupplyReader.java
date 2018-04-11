package CS2033;

import java.util.ArrayList;

public class SupplyReader {

	private Ireader reader;
	
	public SupplyReader(String path, String sheet){
		reader = new ExcelIO(path,sheet);
	}
	
	public ArrayList<Period> getTaught(String name, String[] periodNames){
		ArrayList<Period> taught=new ArrayList<Period>();
		for(int i = 0; i <periodNames.length;i++) {
			taught.add(new Period(name,periodNames[i],"free"));
		}
		ArrayList<String> teachers=reader.readField("Name");
		ArrayList<String> periodData=new ArrayList<String>();
		
		for(int i = 1; i < teachers.size(); i++) {
			periodData = reader.readRow(teachers.get(i));
			for(int j = 1; j < periodData.size();j++) {
				if((periodData.get(j).equals(name)))
				{
					taught.set(j-1,(new Period(teachers.get(i),periodNames[j-1],"FILLED")));
				}
			}
		}
		return taught;
	}
	
	public ArrayList<String> getSupplies()
	{
		ArrayList<String> teacherID=new ArrayList<String>();
		ArrayList<String> teachers=reader.readField("Name");
		ArrayList<String> periodData=new ArrayList<String>();
		
		for(int i=1; i<teachers.size(); i++)
		{
			periodData=reader.readRow(teachers.get(i));
			for(int j=1;j<periodData.size();j++)
			{
				if(!(periodData.get(j).equals("X"))&&!(periodData.get(j).equals("x"))&&!(periodData.get(j).equals("p"))&&!(periodData.get(j).equals("P")))
				{
					teacherID.add(periodData.get(j));
				}
			}
		}
		return teacherID;
	}
}
