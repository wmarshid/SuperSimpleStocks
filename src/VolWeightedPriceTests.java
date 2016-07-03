import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VolWeightedPriceTests {
	
	Stock sut;
	int marketPrice, totalNumerator, totalDenominator;

	@Before
	public void GivenACommonTypeStockWithRecordedTrades() {
		
		sut = new Stock("ALE", 23, 60);
		marketPrice = 150;
		
		sut.recordTrade(500, INDICATOR.BUY, 149);
		sut.recordTrade(550, INDICATOR.SELL, 151);
		sut.recordTrade(400, INDICATOR.SELL, 152);
		sut.recordTrade(600, INDICATOR.BUY, 154);
		
		totalNumerator = 310750;  // sum of all quantities multiplied by trade price
		totalDenominator = 2050;  // sum of all quantities
		
	}
	
	@Test
	public void VolWeightPriceIsAsShownByFormula() {
		double expectedResult = totalNumerator / totalDenominator;
		
		double result = sut.calcVolWeightedStockPrice();
		assert(result == expectedResult);
	}

	@Test
	public void VolWeightCalcOnlyForRecentTrades() {
		fail("Not yet implemented");
	}

}
