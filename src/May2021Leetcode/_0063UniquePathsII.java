package May2021Leetcode;

public class _0063UniquePathsII {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(
				new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 0, 1 }, new int[] { 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

		for (int i = 1; i < obstacleGrid.length; i++) {
			dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
		}

		for (int i = 1; i < obstacleGrid[0].length; i++) {
			dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}

}
