import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Trade.INDICATOR;

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
	
	public void populateSutWithTrades(Stock sut) {
		sut.recordTrade(500, INDICATOR.BUY, 149);
		sut.recordTrade(550, INDICATOR.BUY, 151);
		sut.recordTrade(400, INDICATOR.BUY, 152);
		sut.recordTrade(600, INDICATOR.BUY, 154);
	}
	
	@Test
	public void VolWeightPriceIsAsShownByFormula() {
		
	}

}
