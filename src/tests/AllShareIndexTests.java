package tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trading.Stock;
import trading.TradeHelper;

public class AllShareIndexTests {
	
	List<Stock> sut;
	int totalParValue;
	
	int[] marketPrices;
	int totalMarketPrice;

	@Before
	public void GivenAnIndexOfStocksWithVaryingParValues() {
		
		sut = new ArrayList<Stock>();
		sut.add(new Stock("TEA", 0, 100));
		sut.add(new Stock("POP", 8, 100));
		sut.add(new Stock("ALE", 23, 60));
		sut.add(new Stock("GIN", 8, 100, 2));
		sut.add(new Stock("JOE", 13, 250));
		
		totalParValue = 100 * 100 * 60 * 100 * 250;
		
		marketPrices = new int[] {152,146,87,94,192};
		totalMarketPrice = 152 * 146 * 87 * 94 * 192;
	}

	@Test
	public void CalculateAllShareIndexOfParValues() {
		float N = (float) 1 / sut.size();
		double expectedResult = Math.pow(totalParValue, N); // geometric mean formula
		double actualResult = TradeHelper.calcAllShareIndex(sut);
		assert(actualResult == expectedResult);
	}
	
	@Test
	public void CalculateAllShareIndexOfMarketPrices() {
		float N = (float) 1 / marketPrices.length;
		double expectedResult = Math.pow(totalMarketPrice, N); // geometric mean formula
		double actualResult = TradeHelper.calcAllShareIndex(marketPrices);
		assert(actualResult == expectedResult);
	}

}
