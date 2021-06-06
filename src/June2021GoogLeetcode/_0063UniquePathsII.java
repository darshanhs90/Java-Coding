package June2021GoogLeetcode;

public class _0063UniquePathsII {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(
				new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 0, 1 }, new int[] { 0, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 1 }, new int[] { 1, 0 } }));
		System.out.println(uniquePathsWithObstacles(new int[][] { new int[] { 1, 0 } }));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] out = new int[obstacleGrid.length][obstacleGrid[0].length];
		if (obstacleGrid[0][0] == 1)
			return 0;
		out[0][0] = 1;
		for (int i = 1; i < out[0].length; i++) {
			if (obstacleGrid[0][i] == 1) {
				out[0][i] = 0;
			} else {
				out[0][i] = out[0][i - 1];
			}
		}

		for (int i = 1; i < out.length; i++) {
			if (obstacleGrid[i][0] == 1) {
				out[i][0] = 0;
			} else {
				out[i][0] = out[i - 1][0];
			}
		}

		for (int i = 1; i < out.length; i++) {
			for (int j = 1; j < out[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					out[i][j] = 0;
				} else {
					out[i][j] = out[i - 1][j] + out[i][j - 1];
				}
			}
		}
		return out[out.length - 1][out[0].length - 1];
	}

}
