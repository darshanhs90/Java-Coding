package April2021Leetcode;

public class _0073SetMatrixZeroes {

	public static void main(String[] args) {
		setZeroes(new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 0, 1 }, new int[] { 1, 1, 1 }, });
		setZeroes(new int[][] { new int[] { 0, 1, 2, 0 }, new int[] { 3, 4, 5, 2 }, new int[] { 1, 3, 1, 5 }, });
	}

	public static void setZeroes(int[][] matrix) {
		boolean rowArr[] = new boolean[matrix.length];
		boolean colArr[] = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rowArr[i] = true;
					colArr[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rowArr[i] || colArr[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
