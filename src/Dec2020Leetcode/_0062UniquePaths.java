package Dec2020Leetcode;

import java.util.Arrays;

public class _0062UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 3));
	}

	public static int uniquePathsRecursive(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		else if (m < 1 || n < 1)
			return 0;
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 1);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i - 1 >= 0 && j - 1 >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[m - 1][n - 1];
	}
}
