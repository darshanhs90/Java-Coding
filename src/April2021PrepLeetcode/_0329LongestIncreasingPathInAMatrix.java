package April2021PrepLeetcode;

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
		int maxLength = 0;
		int[][] cache = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				maxLength = Math.max(maxLength, dfs(i, j, matrix[i][j], matrix, cache));
			}
		}
		return maxLength;
	}

	public static int dfs(int x, int y, int currVal, int[][] matrix, int[][] cache) {
		if (cache[x][y] != 0)
			return cache[x][y];

		int maxLen = 1;

		if (x - 1 >= 0 && matrix[x - 1][y] > currVal) {
			maxLen = Math.max(maxLen, 1 + dfs(x - 1, y, matrix[x - 1][y], matrix, cache));
		}

		if (y - 1 >= 0 && matrix[x][y - 1] > currVal) {
			maxLen = Math.max(maxLen, 1 + dfs(x, y - 1, matrix[x][y - 1], matrix, cache));
		}

		if (x + 1 < matrix.length && matrix[x + 1][y] > currVal) {
			maxLen = Math.max(maxLen, 1 + dfs(x + 1, y, matrix[x + 1][y], matrix, cache));
		}

		if (y + 1 < matrix[0].length && matrix[x][y + 1] > currVal) {
			maxLen = Math.max(maxLen, 1 + dfs(x, y + 1, matrix[x][y + 1], matrix, cache));
		}

		cache[x][y] = maxLen;
		return maxLen;
	}

}
