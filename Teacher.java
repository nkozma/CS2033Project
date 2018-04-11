package CS2033;

import java.util.ArrayList;

public abstract class Teacher {
	private String id;
	private ArrayList<Period> periodTaught=new ArrayList<Period>();
	private static final String[] PeriodNames= {"P1","P2","P3a","P3b","P4","P5"};
	
	public Teacher(String ID)
	{
		id=ID;
	}
	
	public String getID() {return id;}
	
	public String[] getPeriodNames() {return PeriodNames;}
	
	public void setTaught(ArrayList<Period> p)
	{
		periodTaught=p;
	}
	
	public ArrayList<Period> getTaught()
	{
		return periodTaught;
	}
	
	public void setPeriod(Period p, int index)
	{
		periodTaught.set(index, p);
	}
	
	public abstract boolean isFreePeriod(String period);
	
	public String toString()
	{
		String periodsTaught="[";
		for(int i=0; i<periodTaught.size();i++)
		{
			periodsTaught=periodsTaught+" "+periodTaught.get(i).getClassName();
		}
		periodsTaught=periodsTaught+"]";
		
		return String.format("Name: %s\nTeaches: %s\n",id,periodsTaught);
	}
}
