package leetCode;

/*
 * Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class _122BestTimeToBuyAndSellStock2 {
	public static int maxProfit(int[] prices) {
		int profit=0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i]-prices[i-1]>0)
				profit+=prices[i]-prices[i-1];
		}
		
		return profit;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{1,3,2,5,62,34,5,8,56}));
	}
}