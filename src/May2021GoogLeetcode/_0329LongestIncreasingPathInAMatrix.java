package May2021GoogLeetcode;

public class _0329LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int maxLength = 1;
		int[][] cache = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxLength = Math.max(maxLength, dfs(i, j, matrix[i][j], matrix, cache));
			}
		}
		return maxLength;
	}

	public static int dfs(int x, int y, int currVal, int[][] matrix, int[][] cache) {
		if (cache[x][y] != 0)
			return cache[x][y];

		int maxLength = 1;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length)
				continue;
			if (matrix[newX][newY] <= currVal)
				continue;
			maxLength = Math.max(maxLength, 1 + dfs(newX, newY, matrix[newX][newY], matrix, cache));
		}
		cache[x][y] = maxLength;
		return maxLength;
	}

}
