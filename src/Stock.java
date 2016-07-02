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
	
	// constructor for common stock
	public Stock(String ticker, int lastDiv, int parValue) {
		this.ticker = ticker;
		this.lastDividend = lastDiv;
		this.parValue = parValue;
		this.stockType = TYPE.COMMON;
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
}
