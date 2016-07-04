import java.util.List;

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
		int actualResult = sut.calcDividendYield(marketPrice);
		assert(actualResult == expectedResult);
	}
	
	@Test
	public void PERatioIsMarketPriceOverDividend() {
		int expectedResult = marketPrice / sut.getLastDividend();
		int actualResult = sut.calcPriceEarningsRatio(marketPrice);
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
