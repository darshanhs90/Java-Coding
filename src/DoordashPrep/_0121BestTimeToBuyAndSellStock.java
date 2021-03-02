package DoordashPrep;

public class _0121BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(maxProfit(new int[] { 3, 2, 6, 5, 0, 3 }));
		System.out.println(maxProfit(new int[] { 1, 2 }));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int minSoFar = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minSoFar) {
				minSoFar = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
		}
		return maxProfit;
	}
}
