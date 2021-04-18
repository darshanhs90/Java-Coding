package April2021PrepLeetcode;

public class _0064MinimumSumPath {

	public static void main(String[] args) {
		System.out.println(
				minPathSum(new int[][] { new int[] { 1, 3, 1 }, new int[] { 1, 5, 1 }, new int[] { 4, 2, 1 }, }));

		System.out.println(minPathSum(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, }));
	}

	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		for (int i = 1; i < grid.length; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			grid[0][i] += grid[0][i - 1];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

}
