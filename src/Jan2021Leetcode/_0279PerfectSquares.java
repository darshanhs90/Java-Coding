package Jan2021Leetcode;

import java.util.Arrays;

public class _0279PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

	public static int numSquares(int n) {
		if (n <= 0)
			return 0;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int squaresUpperBound = (int) (Math.sqrt(n) + 1);
		int[] squares = new int[squaresUpperBound];

		for (int i = 0; i < squares.length; i++) {
			squares[i] = i * i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < squares.length; j++) {
				if (i < squares[j])
					continue;
				dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
			}
		}

		return dp[n];
	}

}
