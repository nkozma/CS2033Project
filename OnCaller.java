package CS2033;

import java.util.ArrayList;
import java.util.Arrays;

public class OnCaller extends Teacher{
	
	private Talley onCallHours;
	private boolean[] absent = {false, false, false, false, false, false};
	
	public OnCaller(String id) {
		super(id);
		onCallHours=new Talley(id);
		OnCallReader reader=new OnCallReader("data/CS2033template.xlsx", "Schedule", "Week");
		super.setTaught(reader.getTaught(id,getPeriodNames()));
		absent=reader.getAbsent(id, getPeriodNames());
	}
	
	public boolean isFreePeriod(String period) {
		boolean free=false;
		String[] periodNames=super.getPeriodNames();
		ArrayList<Period> periods=super.getTaught();
		for(int i=0; i<periodNames.length;i++) {
			if(period.equals(periodNames[i])) {
				if (periods.get(i).getClassName().equals("free")&&!(onCallHours.isOverQuota())&&!(absent[i]))
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
		
		return String.format(super.toString()+"Oncall hours used: %d\nIs Absent:"+Arrays.toString(absent)+"\n\n",onCallHours.getHours());
	}
}
