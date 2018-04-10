package CS2033;

import java.util.ArrayList;

public class Supply extends Teacher{

	public Supply(String id) {
		super(id);
		SupplyReader reader = new SupplyReader("data/CS2033template.xlsx","Week");
		super.setTaught(reader.getTaught(id,getPeriodNames()));
	}

	public boolean isFreePeriod(String period) {

		boolean free = false;
		String[] periodNames=super.getPeriodNames();
		ArrayList<Period> periods=super.getTaught();
		for(int i=0; i<periodNames.length;i++) {
			if(period.equals(periodNames[i])) {
				if (periods.get(i).getClassName().equals("free"))
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
		
		return String.format(super.toString());
	}

}
