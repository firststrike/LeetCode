package leetCode;

public class BestTime2BuyAndSellStock {
	public int maxProfit(int[] prices) {
		int sum = 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int price = prices[i] - prices[i - 1];
			if (sum <= 0) {
				sum = price;
			} else {
				sum += price;
			}
			if (profit < sum) {
				profit = sum;
			}
		}
		return profit;
	}
}
