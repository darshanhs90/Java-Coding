package Nov2020_UberPrep;

public class _032PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(6));
		System.out.println(numSquares(12));
		System.out.println(numSquares(13));
	}

	public static int numSquares(int n) {
		if (n <= 3)
			return n;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
			}

		}
		return dp[n];
	}
}
