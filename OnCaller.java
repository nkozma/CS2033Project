package project.group2.system.njk;

import java.util.ArrayList;

public class OnCaller extends Teacher{
	
	private Talley onCallHours;
	
	public OnCaller(String id) {
		super(id);
		onCallHours=new Talley(id);
		OnCallReader reader=new OnCallReader("data/CS2033template.xlsx", "Schedule");
		super.setTaught(reader.getTaught(id,getPeriodNames()));
	}
	
	public boolean isFreePeriod(String period) {
		boolean free=false;
		String[] periodNames=super.getPeriodNames();
		ArrayList<Period> periods=super.getTaught();
		for(int i=0; i<periodNames.length;i++) {
			if(period.equals(periodNames[i])) {
				if (periods.get(i).getClassName().equals("free")&&!(onCallHours.isOverQuota()))
				{
					free=true;
				}
				break;
			}
		}
		return free;
	}

	public String toString()
	{
		
		return String.format(super.toString()+"Oncall hours used: %d",onCallHours.getHours());
	}
}
