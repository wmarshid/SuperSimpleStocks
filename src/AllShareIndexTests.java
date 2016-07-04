import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AllShareIndexTests {
	
	List<Stock> sut;
	int totalParValue;
	int root;

	@Before
	public void GivenAnIndexOfStocksWithVaryingParValues() {
		
		sut = new ArrayList<Stock>();
		sut.add(new Stock("TEA", 0, 100));
		sut.add(new Stock("POP", 8, 100));
		sut.add(new Stock("ALE", 23, 60));
		sut.add(new Stock("GIN", 8, 100));
		sut.add(new Stock("JOE", 13, 250));
		
		totalParValue = 100 * 100 * 60 * 100 * 250;
		root = sut.size();
	}

	@Test
	public void CalculateAllShareIndexUsingGeometricMean() {
		float N = (float) 1 / root;
		double expectedResult = Math.pow(totalParValue, N); // geometric mean formula
		double actualResult = TradeHelper.calcAllShareIndex(sut);
		assert(actualResult == expectedResult);
	}

}
