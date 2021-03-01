package FacebookPrep;

public class _0329LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	static int maxPath;

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		maxPath = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(i, j, matrix[i][j], matrix, 1);
			}
		}
		return maxPath;
	}

	public static void dfs(int x, int y, int currVal, int[][] matrix, int currLength) {
		maxPath = Math.max(maxPath, currLength);

		if (x - 1 >= 0 && matrix[x - 1][y] > currVal) {
			dfs(x - 1, y, matrix[x - 1][y], matrix, currLength + 1);
		}

		if (y - 1 >= 0 && matrix[x][y - 1] > currVal) {
			dfs(x, y - 1, matrix[x][y - 1], matrix, currLength + 1);
		}

		if (x + 1 < matrix.length && matrix[x + 1][y] > currVal) {
			dfs(x + 1, y, matrix[x + 1][y], matrix, currLength + 1);
		}

		if (y + 1 < matrix[0].length && matrix[x][y + 1] > currVal) {
			dfs(x, y + 1, matrix[x][y + 1], matrix, currLength + 1);
		}
	}

}
