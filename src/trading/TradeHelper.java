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
	
	private static double calcGeometricMean(int totalPrice, int root) {
		// calculates the geometric mean of prices for all stocks
		float N = (float) 1 / root;
		double result = Math.pow(totalPrice, N);
		return result;
	}
	
	public static double calcAllShareIndex(List<Stock> stocks) {

		// get the product of all par values
		int totalParValue = 1;
		for (Stock s : stocks) {
			totalParValue *= s.getParValue();
		}
		return calcGeometricMean(totalParValue, stocks.size());
	}
	
	public static double calcAllShareIndex(int[] marketPrices) {
		
		// get the product of all market prices
		int totalMarketPrice = 1;
		for (int price : marketPrices) {
			totalMarketPrice *= price;
		}
		return calcGeometricMean(totalMarketPrice, marketPrices.length);
	}
	

}
