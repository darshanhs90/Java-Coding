package Leetcode2020Nov;

public class _0063UniquePathsII {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(
				new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 0, 1 }, new int[] { 0, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		return uniquePaths(0, 0, obstacleGrid);
	}

	public static int uniquePaths(int x, int y, int[][] obstacleGrid) {
		if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1 && obstacleGrid[x][y] == 0) {
			return 1;
		}

		if (x > obstacleGrid.length - 1 || y > obstacleGrid[0].length - 1 || obstacleGrid[x][y] == 1) {
			return 0;
		}
		return uniquePaths(x + 1, y, obstacleGrid) + uniquePaths(x, y + 1, obstacleGrid);
	}
}
