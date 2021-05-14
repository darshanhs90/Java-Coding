package May2021Leetcode;

public class _0122BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(maxProfit(new int[] { 3, 2, 6, 5, 0, 3 }));
		System.out.println(maxProfit(new int[] { 1, 2 }));
	}

	public static int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				max += prices[i + 1] - prices[i];
			}
		}
		return max;
	}
}
