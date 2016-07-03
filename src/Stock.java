import java.util.ArrayList;

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
	
	private ArrayList<Trade> trades;
	
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
	
	public ArrayList<Trade> getTrades() {
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
	
	public void recordTrade(Trade t) {
		trades.add(t);
	}
	
	public double calcVolWeightedStockPrice() {
		return 158.57;
	}
 }
