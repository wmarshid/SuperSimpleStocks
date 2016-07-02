import java.util.Calendar;
import java.util.Date;


public class Trade {
	
	public enum INDICATOR {
		BUY,
		SELL;
	}
	
	private Date timestamp;
	private int quantity;
	private INDICATOR tradeType;
	private int tradePrice;
	
	public Trade(int quantity, INDICATOR tradeType, int tradePrice) {
		Calendar calendar = Calendar.getInstance();
		timestamp = calendar.getTime();
		this.quantity = quantity;
		this.tradeType = tradeType;
		this.tradePrice = tradePrice;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getTradePrice() {
		return tradePrice;
	}
}
