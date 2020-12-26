package Dec2020Leetcode;

public class _0063UniquePathsII {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(
				new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 0, 1 }, new int[] { 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 0)
					obstacleGrid[i][j] = 1;
				else {
					obstacleGrid[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 0) {
					continue;
				}

				if (i - 1 >= 0 && j - 1 >= 0) {
					if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
						obstacleGrid[i][j] = 0;
					} else if (obstacleGrid[i - 1][j] == 0) {
						obstacleGrid[i][j] = obstacleGrid[i][j - 1];
					} else if (obstacleGrid[i][j - 1] == 0) {
						obstacleGrid[i][j] = obstacleGrid[i - 1][j];
					} else {
						obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
					}
				} else if (i - 1 >= 0) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				} else if (j - 1 >= 0) {
					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				}
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

}
