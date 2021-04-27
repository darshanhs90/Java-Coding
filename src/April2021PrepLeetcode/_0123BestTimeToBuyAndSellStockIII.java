package April2021PrepLeetcode;

public class _0123BestTimeToBuyAndSellStockIII {
	public static void main(String[] args) {
		// System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
		// System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
		// System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		// System.out.println(maxProfit(new int[] { 1 }));

		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int left[] = new int[prices.length];
		int right[] = new int[prices.length];

		left[0] = 0;
		int minSoFar = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minSoFar) {
				minSoFar = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
			left[i] = maxProfit;
		}

		right[prices.length - 1] = 0;
		int maxSoFar = prices[prices.length - 1];
		maxProfit = 0;
		for (int i = prices.length - 2; i >= 0; i--) {
			if (prices[i] > maxSoFar) {
				maxSoFar = prices[i];
			}
			maxProfit = Math.max(maxProfit, -prices[i] + maxSoFar);
			right[i] = maxProfit;
		}

		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			int leftVal = left[i];
			int rightVal = i + 1 < prices.length ? right[i + 1] : 0;

			max = Math.max(max, leftVal + rightVal);
		}
		return max;
	}
}
