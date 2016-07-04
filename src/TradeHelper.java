import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TradeHelper {
	
	static final long ONE_MINUTE_IN_MILLIS=60000;
	
	private static Boolean lessThanFifteenMinutesOld(Trade t) {
		
		Calendar date = Calendar.getInstance();
		long time = date.getTimeInMillis();
		Date timeThreshhold = new Date(time - (15 * ONE_MINUTE_IN_MILLIS + 1));
		
		return t.getTimestamp().after(timeThreshhold);
	}
	
	public static List<Trade> getRecentTrades(List<Trade> trades) {
		
		List<Trade> recentTrades = new ArrayList<Trade>();
				
		for (Trade t : trades) {
			if (lessThanFifteenMinutesOld(t)) {
				recentTrades.add(t);
			}
		}
		
		return recentTrades;
	}

}
