package Jan2021Leetcode;

public class _0063UniquePathsII {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(
				new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 0, 1 }, new int[] { 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0)
			return 0;

		int rows = obstacleGrid.length - 1;
		int cols = obstacleGrid[0].length - 1;

		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

		dp[0][0] = obstacleGrid[0][0] == 1 ? -1 : 1;

		for (int i = 1; i <= cols; i++) {
			int prevVal = dp[0][i - 1];
			dp[0][i] = obstacleGrid[0][i] == 1 ? -1 : prevVal;
		}

		for (int i = 1; i <= rows; i++) {
			int prevVal = dp[i - 1][0];
			dp[i][0] = obstacleGrid[i][0] == 1 ? -1 : prevVal;
		}

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = -1;
				} else {
					if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
						dp[i][j] = -1;
					} else if (dp[i - 1][j] == -1) {
						dp[i][j] = dp[i][j - 1];
					} else if (dp[i][j - 1] == -1) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}
			}
		}
		return dp[rows][cols] == -1 ? 0 : dp[rows][cols];
	}

}
