package LeetCodePractice;

public class _121BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{100, 90, 80, 70, 60,110}));
	}
	public static int maxProfit(int[] prices) {
		if(prices.length<1)
			return 0;
		int min=prices[0];
		int maxProfit=0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit=Math.max(maxProfit, prices[i]-min);
			min=Math.min(min, prices[i]);
		}
		return maxProfit;
	}
}

