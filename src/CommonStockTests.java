import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CommonStockTests {
	
	Stock sut;
	int marketPrice;

	@Before
	public void GivenACommonTypeStockWithLastDividend23() {
		sut = new Stock("ALE", 23, 60);
		marketPrice = 150;
	}
	
	@Test
	public void DividendYieldIsLastDivOverMarketPrice() {
		int expectedResult =  sut.getLastDividend() / marketPrice;
		int result = sut.calcDividendYield(marketPrice);
		assert(result == expectedResult);
	}
	
	@Test
	public void PERatioIsMarketPriceOverDividend() {
		int expectedResult = marketPrice / sut.getLastDividend();
		int result = sut.calcPriceEarningsRatio(marketPrice);
		assert(expectedResult == result);
	}
	
	@Test
	public void TradeRetrievedIsSameAsOneRecorded() {
		int expectedQuantity = 1000;
		sut.recordTrade(expectedQuantity, INDICATOR.BUY, marketPrice * expectedQuantity);
		ArrayList<Trade> result = sut.getTrades();
		assert(result.get(0).getQuantity() == expectedQuantity);
	}
	
	@Ignore
	public void populateSutWithTrades(List<Trade> trades) {
		
		for (Trade t : trades) {
			sut.recordTrade(t);
		}
	}
	
	@Test
	public void VolWeightPriceIsAsShownByFormula() {
		List<Trade> trades = new ArrayList<Trade>();
		trades.add(new Trade(500, INDICATOR.BUY, 149));
		trades.add(new Trade(550, INDICATOR.SELL, 151));
		trades.add(new Trade(400, INDICATOR.SELL, 152));
		trades.add(new Trade(600, INDICATOR.BUY, 154));
		
		int totalNumerator = 310750;  // sum of all quantities multiplied by trade price
		int totalDenominator = 2050;  // sum of all quantities
		double expectedResult = totalNumerator / totalDenominator;
		
		// populate sut with trades
		for (Trade t : trades) {
			sut.recordTrade(t);
		}
		
		double result = sut.calcVolWeightedStockPrice();
		assert(result == expectedResult);
	}
	
	@Test
	public void VolWeightCalcOnlyForRecentTrades() {
		assert(false);
	}

}
