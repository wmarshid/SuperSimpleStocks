package trading;
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
	
	public static double calcAllShareIndex(List<Stock> stocks) {

		// get the product of all par values
		int totalParValue = 1;
		for (Stock s : stocks) {
			totalParValue *= s.getParValue();
		}
		
		// calculates the geometric mean of par values for all stocks
		int root = stocks.size();
		float N = (float) 1 / root;
		double result = Math.pow(totalParValue, N);
		return result;
	}
	

}
