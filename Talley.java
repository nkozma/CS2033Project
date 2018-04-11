package CS2033;

public class Talley {
	
	private TalleyIO IO;
	private int talleyHours;
	private String name;
	private static int maxHours=4;
	private final String sheetName="CurrentTalleys";
	private final String inputFile="data/TalleySheet.xlsx";
	
	public Talley(String name)
	{
		IO=new TalleyIO(inputFile, sheetName);
		this.name=name;
		talleyHours=IO.findTalley(name);
	}
	
	public int getHours() {return talleyHours;}
	public void incrementHours() {talleyHours++;}
	
	public boolean isOverQuota()
	{
		boolean areThey=false;
		if(talleyHours>=maxHours){areThey=true;}
		return areThey;
	}
	
	public void updateHours()
	{
		IO.updateTalley(name, talleyHours, maxHours-talleyHours);
	}
}