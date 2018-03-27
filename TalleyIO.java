package project.group2.system.njk;

public class TalleyIO {
	private IProcessor iP;
	private final String TALLEYINFO= "Total Worked";
	
	public TalleyIO(String inputfile, String sheetName)
	{
		iP=new ExcelIO(inputfile,sheetName);
	}
	
	public void updateTalley(String name, int hours, int remaining)
	{
		iP.write(name, TALLEYINFO, Integer.toString(hours));
		iP.write(name, "Remaining", Integer.toString(remaining));
	}
	
	public int findTalley(String name)
	{
		return (int)Double.parseDouble(iP.read(name, TALLEYINFO));
	}
}
