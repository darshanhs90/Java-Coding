package Nov2020Leetcode;

public class _0064MinimumSumPath {

	public static void main(String[] args) {
		System.out.println(
				minPathSum(new int[][] { new int[] { 1, 3, 1 }, new int[] { 1, 5, 1 }, new int[] { 4, 2, 1 }, }));

		System.out.println(minPathSum(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, }));
	}

	public static int minPathSum(int[][] grid) {
		return minPathSum(0, 0, 0, grid);
	}

	public static int minPathSum(int x, int y, int prevSum, int[][] grid) {
		if (x > grid.length - 1 || y > grid[0].length - 1)
			return Integer.MAX_VALUE;
		if (x == grid.length - 1 && y == grid[0].length - 1) {
			return prevSum + grid[x][y];
		}
		return Math.min(minPathSum(x + 1, y, prevSum + grid[x][y], grid),
				minPathSum(x, y + 1, prevSum + grid[x][y], grid));
	}
}
