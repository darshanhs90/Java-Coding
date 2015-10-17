package leetCode;

/*
 * Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class _121BestTimeToBuyAndSellStock {
	public static int maxProfitLong(int[] prices) {
		int profit=0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				if((prices[j]-prices[i])>profit)
					profit=prices[j]-prices[i];
			}
		}
		return profit;
	}
	public static int maxProfit(int[] prices) {
		 int profit = 0;
		    int minElement = Integer.MAX_VALUE;
		    for(int i=0; i<prices.length; i++){
		       profit = Math.max(profit, prices[i]-minElement);
		       minElement = Math.min(minElement, prices[i]);
		    }
		    return profit;
	}

	public static void main(String[] args) {
			System.out.println(maxProfit(new int[]{1,2,4}));
	}
}