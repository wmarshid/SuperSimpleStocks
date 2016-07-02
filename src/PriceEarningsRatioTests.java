import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriceEarningsRatioTests {
	
	Stock sut;
	int marketPrice = 150;

	@Before
	public void GivenAStockWithDividend13() {
		sut = new Stock("JOE", 13, 250);
	}

	@Test
	public void PERatioIsMarketPriceOverDividend() {
		int expectedResult = marketPrice / sut.getLastDividend();
		int result = sut.calcPriceEarningsRatio(marketPrice);
		assert(expectedResult == result);
	}

}
