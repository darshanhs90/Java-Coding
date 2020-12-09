package Nov2020_FBPrep;

public class _061BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 2, 1 }));
	}

	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int diff = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				if (prices[i] - min > diff) {
					diff = prices[i] - min;
				}
			}
		}

		return diff;
	}
}
