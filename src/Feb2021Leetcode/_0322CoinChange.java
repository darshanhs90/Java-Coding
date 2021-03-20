package Feb2021Leetcode;

import java.util.Arrays;

public class _0322CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 5 }, 11));
		System.out.println(coinChange(new int[] { 2 }, 3));
		System.out.println(coinChange(new int[] { 1 }, 0));
		System.out.println(coinChange(new int[] { 1 }, 1));
		System.out.println(coinChange(new int[] { 1 }, 2));
		System.out.println(coinChange(new int[] { 2, 5, 10, 1 }, 27));
		System.out.println(coinChange(new int[] { 186, 419, 83, 408 }, 6249));

	}

	public static int coinChange(int[] coins, int amount) {

		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			int coinVal = coins[i];
			for (int j = 1; j < dp.length; j++) {
				if (j < coinVal)
					continue;
				dp[j] = Math.min(dp[j], dp[j - coinVal] + 1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

}
