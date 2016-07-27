package eBayPrep;

public class _121BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{100, 90, 80, 70, 60,110}));
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

	}
	public static int maxProfit(int[] prices) {
		if(prices==null||prices.length==0)
			return 0;
		int maxProfit=0;
		int min=prices[0];
		for (int i = 0; i < prices.length; i++) {
			maxProfit=Math.max(maxProfit, prices[i]-min);
			min=Math.min(min, prices[i]);
		}
		return maxProfit;
	}
}

