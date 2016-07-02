import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DividendYieldCommonTests {
	
	Stock sut;
	int marketPrice;

	@Before
	public void GivenACommonTypeStockWithLastDividend23() {
		sut = new Stock("ALE", 23, 60);
		marketPrice = 150;
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void DividendYieldIsLastDivOverMarketPrice() {
		int expectedResult =  sut.getLastDividend() / marketPrice;
		int result = sut.calcDividendYield(marketPrice);
		assert(result == expectedResult);
	}

}
