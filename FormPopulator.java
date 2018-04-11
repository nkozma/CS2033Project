package CS2033;

import java.util.ArrayList;

public class FormPopulator {
	
	private Iwriter writer;
	
	public FormPopulator(String path, String sheet)
	{
		writer=new ExcelIO(path, sheet);
	}
	
	public void fillOnCaller(ArrayList<AbsentPeriod> [] fill)
	{
		String[] PeriodNames= {"P1","P2","P3a","P3b","P4","P5"};
		
		for(int i=0; i<fill.length; i++)
		{
			for(int j=0; j<fill[i].size(); j++)
			{
				writer.write(fill[i].get(j).getTeacher(), PeriodNames[i], fill[i].get(j).getSub());
			}
		}
	}
}
