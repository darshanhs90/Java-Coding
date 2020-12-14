package Nov2020_GoogPrep;

public class _061BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int maxProfit = 0;
		int minValue = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minValue) {
				minValue = prices[i];
			}

			maxProfit = Math.max(maxProfit, prices[i] - minValue);
		}
		return maxProfit;
	}
}
