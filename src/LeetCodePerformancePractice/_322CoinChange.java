package LeetCodePerformancePractice;

public class _322CoinChange {
	public static void main(String[] args) {
		System.out.println(coinChange(new int[]{1,2,5},11));
	}
	public static int coinChange(int[] coins, int amount) {
		int dp[]=new int[amount+1];
		dp[0]=0;
		for (int i = 1; i < dp.length; i++) {
			dp[i]=Integer.MAX_VALUE;
		}

		for (int i = 0; i <=amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				int coin=coins[j];
				if(i+coin<=amount)
				{
					if(dp[i]==Integer.MAX_VALUE)
					{
						dp[i+coin]=dp[coin+i];
					}
					else{
						dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
					}
				}
			}
		}
		if(dp[amount] >= Integer.MAX_VALUE)
			return -1;
		return dp[amount];
	}


}
