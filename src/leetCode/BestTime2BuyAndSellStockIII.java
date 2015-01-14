package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gengyu.bi on 2014/12/22.
 */
public class BestTime2BuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		List<Integer> maxEndWith = new ArrayList<Integer>();
		int lowest = prices[0];
		int maxprofit = 0;
		maxEndWith.add(0);
		for (int i = 1; i < prices.length; ++i) {
			int profit = prices[i] - lowest;
			if (profit > maxprofit) {
				maxprofit = profit;
			}
			maxEndWith.add(maxprofit);
			if (prices[i] < lowest) {
				lowest = prices[i];
			}
		}
		int result = maxEndWith.get(prices.length - 1);
		int highest = prices[prices.length - 1];
		maxprofit = 0;
		for (int i = prices.length - 2; i >= 0; --i) {
			int profit = highest - prices[i];
			if (profit > maxprofit) {
				maxprofit = profit;
			}
			int finalprofit = maxprofit + maxEndWith.get(i);
			if (finalprofit > result) {
				result = finalprofit;
			}
			if (prices[i] > highest) {
				highest = prices[i];
			}
		}
		return result;
	}

}
