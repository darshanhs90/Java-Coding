package Nov2020_UberPrep;

import java.util.Arrays;

public class _035CherryPickup {

	public static void main(String[] args) {
		System.out.println(
				cherryPickup(new int[][] { new int[] { 0, 1, -1 }, new int[] { 1, 0, -1 }, new int[] { 1, 1, 1 } }));

		System.out.println(
				cherryPickup(new int[][] { new int[] { 1, 1, -1 }, new int[] { 1, -1, 1 }, new int[] { -1, 1, 1 } }));
	}

	public static int cherryPickup(int[][] grid) {
		int n = grid.length;
		int[][][] dp = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		return Math.max(0, dfs(0, 0, 0, grid, dp, n));
	}

	public static int dfs(int r1, int c1, int c2, int[][] grid, int[][][] dp, int n) {
		int r2 = r1 + c1 - c2;
		if (r1 >= n || c1 >= n || c2 >= n || r2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
			return Integer.MIN_VALUE;
		if (dp[r1][c1][c2] != -1)
			return dp[r1][c1][c2];
		if (r1 == n - 1 && c1 == n - 1)
			return grid[r1][c1];

		int ans = grid[r1][c1];
		if (c1 != c2)
			ans += grid[r2][c2];

		int tempVal = Math.max(dfs(r1, c1 + 1, c2 + 1, grid, dp, n), dfs(r1 + 1, c1, c2 + 1, grid, dp, n));
		tempVal = Math.max(tempVal, dfs(r1, c1 + 1, c2, grid, dp, n));
		tempVal = Math.max(tempVal, dfs(r1 + 1, c1, c2, grid, dp, n));
		ans += tempVal;
		dp[r1][c1][c2] = ans;
		return ans;
	}

}
