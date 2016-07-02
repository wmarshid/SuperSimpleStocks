import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PreferredStockTests {

	Stock sut;
	int marketPrice;
	
	@Before
	public void GivenAPreferredTypeStockWithFixedDividend2() {
		sut = new Stock("GIN", 8, 100, 2);
		marketPrice = 150;
	}
	
	@Test
	public void DividendYieldIsFixedDivWithParOverMarketPrice() {
		int fixedDivPercentage = sut.getFixedDividend() / 100;
		int expectedResult = (fixedDivPercentage * sut.getParValue()) / 100;
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
		sut.recordTrade(expectedQuantity, Trade.INDICATOR.BUY, marketPrice * expectedQuantity);
		ArrayList<Trade> result = sut.getTrades();
		assert(result.get(0).getQuantity() == expectedQuantity);
	}

}
