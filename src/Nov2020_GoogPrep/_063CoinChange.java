package Nov2020_GoogPrep;

import java.util.Arrays;

public class _063CoinChange {
	// https://www.youtube.com/watch?v=NJuKJ8sasGk&t=937s

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 2 }, 3));
		System.out.println(coinChange(new int[] { 1 }, 0));
		System.out.println(coinChange(new int[] { 1 }, 1));
		System.out.println(coinChange(new int[] { 1 }, 2));
	}

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int j = 0; j < coins.length; j++) {
			int currCoinValue = coins[j];
			for (int i = 1; i < dp.length; i++) {
				if (i < currCoinValue) {
					continue;
				} else {
					int prevValue = dp[i - currCoinValue];
					if (prevValue != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], 1 + dp[i - currCoinValue]);
					}
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
