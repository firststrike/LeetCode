package leetCode;

/**
 * Created by gengyu.bi on 2014/12/22.
 */
public class BestTime2BuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				result += diff;
			}
		}
		return result;
	}
}
