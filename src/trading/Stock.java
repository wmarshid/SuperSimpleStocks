package trading;
import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	public enum TYPE {
		COMMON,
		PREFERRED;
	}
	
	private String ticker;
	private TYPE stockType;
	private int lastDividend;
	private int fixedDividend;
	private int parValue;
	
	private List<Trade> trades;
	
	// constructor for common stock
	public Stock(String ticker, int lastDiv, int parValue) {
		this.ticker = ticker;
		this.lastDividend = lastDiv;
		this.parValue = parValue;
		this.stockType = TYPE.COMMON;
		this.trades = new ArrayList<Trade>();
	}
	
	//constructor for preferred stock
	public Stock(String ticker, int lastDiv, int parValue, int fixedDiv) {
		this.ticker = ticker;
		this.lastDividend = lastDiv;
		this.parValue = parValue;
		this.fixedDividend = fixedDiv;
		this.stockType = TYPE.PREFERRED;
	}

	public String getTicker() {
		return ticker;
	}
	
	public int getLastDividend() {
		return lastDividend;
	}
	
	public int getParValue() {
		return parValue;
	}
	
	public int getFixedDividend() {
		if (stockType == TYPE.PREFERRED) {
			return fixedDividend;
		}
		return 0;
	}
	
	public List<Trade> getAllTrades() {
		return trades;
	}
	
	public Boolean isCommonStock() {
		return (stockType == TYPE.COMMON);
	}
	
	public Boolean isPreferredStock() {
		return (stockType == TYPE.PREFERRED);
	}
	
	public int calcDividendYield(int marketPrice) {
		if (isCommonStock()) {
			return lastDividend / marketPrice;
		}
		else {
			int yield = ((fixedDividend / 100) / parValue);
			return yield / marketPrice;
		}
	}
	
	public int calcPriceEarningsRatio(int marketPrice) {
		return marketPrice / lastDividend;
	}
	
	public void recordTrade(int quantity, INDICATOR tradeType, int tradePrice)  {
		Trade t = new Trade(quantity, tradeType, tradePrice);
		trades.add(t);
	}
	
	public List<Trade> getRecentTrades() {
		return TradeHelper.getRecentTrades(trades);
	}
	
	public float calcVolWeightedStockPrice() {
		// sum of all quantities multiplied by share price over sum of all quantities
		List<Trade> recentTrades = TradeHelper.getRecentTrades(trades);
		int totalPriceQuantity = 0;
		int totalQuantity = 0;
		for (Trade t : recentTrades) {
			int quantity = t.getQuantity();
			int tradePrice = t.getTradePrice();
			totalPriceQuantity += quantity * tradePrice;
			totalQuantity += quantity;
		}
		float result = (float) totalPriceQuantity / totalQuantity;	// casting to float first maintains precision
		return result;
	}
 }
