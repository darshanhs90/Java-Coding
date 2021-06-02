package May2021GoogLeetcode;

import java.util.Arrays;

public class _0279PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

	public static int numSquares(int n) {
		if (n <= 1)
			return n;
		int limit = (int) Math.sqrt(n) + 1;
		int[] coins = new int[limit];
		for (int i = 1; i < coins.length; i++) {
			coins[i] = i * i;
		}

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int s = 1; s < limit; ++s) {
				if (i < coins[s])
					break;
				dp[i] = Math.min(dp[i], dp[i - coins[s]] + 1);
			}
		}
		return dp[n];
	}

}
