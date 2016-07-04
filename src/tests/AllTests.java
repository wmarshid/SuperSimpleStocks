package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllShareIndexTests.class, CommonStockTests.class, PreferredStockTests.class,
		VolWeightedPriceTests.class })
public class AllTests {

}
