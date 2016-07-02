import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DividendYieldPreferredTests {

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

}
