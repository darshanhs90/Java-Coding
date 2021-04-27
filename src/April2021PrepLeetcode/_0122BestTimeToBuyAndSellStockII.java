package April2021PrepLeetcode;

public class _0122BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		}
		return profit;
	}
}
