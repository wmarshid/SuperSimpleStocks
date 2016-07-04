package trading;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StocksRunner {
	
	public Map<String, Stock> sampleStocks;
	
	public StocksRunner() {
		
		sampleStocks = new HashMap<String, Stock>();
		
		// populate list of sample stocks
		sampleStocks.put("TEA", new Stock("TEA", 0, 100));
		sampleStocks.put("POP", new Stock("POP", 8, 100));
		sampleStocks.put("ALE", new Stock("ALE", 23, 60));
		sampleStocks.put("GIN", new Stock("GIN", 8, 100, 2));
		sampleStocks.put("JOE", new Stock("JOE", 13, 250));
	}
	
	public static void stockCalculator(String input) {
		
		// parse the input for a market price and a ticker		
		String[] tokens = input.split(",");
		String ticker = tokens[0];
		int price = Integer.parseInt(tokens[1]);
		
		// create a Map<String, Stock> and populate the sample data in manually
		StocksRunner sr = new StocksRunner();
		
		// calculate the yield and P/E ratio for that ticker
		Stock s = sr.sampleStocks.get(ticker);
		float divYield = s.calcDividendYield(price);
		float peRatio =  s.calcPriceEarningsRatio(price);
		
		// output the yield and P/E ratio for that ticker
		System.out.println("Calculations for |" + ticker + "| at market price: " + price);
		System.out.println("The dividend yield is - " + divYield);
		System.out.println("The Price/Earnings ratio is - " + peRatio);
	}
	
	public static void main(String[] argv) {
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("Please enter a stock ticker followed by the market price i.e. POP,152");
			String input = scan.nextLine();
			stockCalculator(input);
		}
	}

}