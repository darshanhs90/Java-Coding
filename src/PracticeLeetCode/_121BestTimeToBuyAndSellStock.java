package PracticeLeetCode;

public class _121BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
	}
	//http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
	public static int maxProfit(int[] prices) {
		if(prices==null||prices.length==0)
			return 0;
		int min=prices[0];
		int res=0;
		for (int i = 1; i < prices.length; i++) {
			res=Math.max(res, prices[i]-min);
			min=Math.min(min, prices[i]);
		}
		return res;
	}
}
