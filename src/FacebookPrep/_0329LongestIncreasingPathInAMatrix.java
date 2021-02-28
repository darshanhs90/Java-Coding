package FacebookPrep;

public class _0329LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 9, 9, 4 }, new int[] { 6, 6, 8 }, new int[] { 2, 1, 1 } }));
		System.out.println(longestIncreasingPath(
				new int[][] { new int[] { 3, 4, 5 }, new int[] { 3, 2, 6 }, new int[] { 2, 2, 1 } }));
	}

	static int maxLength;

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				getMaxLength(i, j, matrix, 1);
			}
		}
		return maxLength;
	}

	public static void getMaxLength(int i, int j, int[][] matrix, int currLength) {
		maxLength = Math.max(maxLength, currLength);

		int currVal = matrix[i][j];
		if (i - 1 >= 0 && matrix[i - 1][j] > currVal) {
			getMaxLength(i - 1, j, matrix, currLength + 1);
		}

		if (i + 1 < matrix.length && matrix[i + 1][j] > currVal) {
			getMaxLength(i + 1, j, matrix, currLength + 1);
		}

		if (j - 1 >= 0 && matrix[i][j - 1] > currVal) {
			getMaxLength(i, j - 1, matrix, currLength + 1);
		}

		if (j + 1 < matrix[0].length && matrix[i][j + 1] > currVal) {
			getMaxLength(i, j + 1, matrix, currLength + 1);
		}
	}

}
