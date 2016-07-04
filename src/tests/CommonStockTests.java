package tests;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trading.INDICATOR;
import trading.Stock;
import trading.Trade;

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
		float expectedResult = (float) sut.getLastDividend() / marketPrice;
		float actualResult = sut.calcDividendYield(marketPrice);
		assert(actualResult == expectedResult);
	}
	
	@Test
	public void PERatioIsMarketPriceOverDividend() {
		float expectedResult = (float) marketPrice / sut.getLastDividend();
		float actualResult = sut.calcPriceEarningsRatio(marketPrice);
		assert(actualResult == expectedResult);
	}
	
	@Test
	public void TradeRetrievedIsSameAsOneRecorded() {
		int expectedQuantity = 1000;
		sut.recordTrade(expectedQuantity, INDICATOR.BUY, marketPrice * expectedQuantity);
		List<Trade> result = sut.getAllTrades();
		assert(result.get(0).getQuantity() == expectedQuantity);
	}
}
