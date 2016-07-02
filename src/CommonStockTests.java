import static org.junit.Assert.*;

import org.junit.Before;
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

}
