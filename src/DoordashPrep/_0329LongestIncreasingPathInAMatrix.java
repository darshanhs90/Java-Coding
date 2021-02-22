package DoordashPrep;

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
		maxPath = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				findMaxPath(i, j, matrix[i][j], matrix, 1);
			}
		}
		return maxPath;
	}

	public static void findMaxPath(int x, int y, int currVal, int[][] matrix, int length) {
		maxPath = Math.max(maxPath, length);

		if (x - 1 >= 0 && y >= 0 && matrix[x - 1][y] > currVal) {
			findMaxPath(x - 1, y, matrix[x - 1][y], matrix, length + 1);
		}

		if (x + 1 < matrix.length && y >= 0 && matrix[x + 1][y] > currVal) {
			findMaxPath(x + 1, y, matrix[x + 1][y], matrix, length + 1);
		}

		if (x >= 0 && y - 1 >= 0 && matrix[x][y - 1] > currVal) {
			findMaxPath(x, y - 1, matrix[x][y - 1], matrix, length + 1);
		}

		if (x >= 0 && y + 1 < matrix[0].length && matrix[x][y + 1] > currVal) {
			findMaxPath(x, y + 1, matrix[x][y + 1], matrix, length + 1);
		}
	}

}
