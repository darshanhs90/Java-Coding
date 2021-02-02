package Jan2021Leetcode;

public class _0048RotateImage {

	public static void main(String[] args) {
		rotate(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } });
		rotate(new int[][] { new int[] { 5, 1, 9, 11 }, new int[] { 2, 4, 8, 10 }, new int[] { 13, 3, 6, 7 },
				new int[] { 15, 14, 12, 16 } });
		rotate(new int[][] { new int[] { 1 } });
		rotate(new int[][] { new int[] { 1 } });
		rotate(new int[][] { new int[] { 1, 2 }, new int[] { 3, 4 } });
		rotate(new int[][] { new int[] { 1, 2, 3, 4, 5 }, new int[] { 6, 7, 8, 9, 10 },
				new int[] { 11, 12, 13, 14, 15 }, new int[] { 16, 17, 18, 19, 20 }, new int[] { 21, 22, 23, 24, 25 } });
	}

	public static void rotate(int[][] matrix) {
		swapRows(matrix);
		swapDiagonalElements(matrix);
	}

	public static void swapRows(int[][] matrix) {
		int topRow = 0, bottomRow = matrix.length - 1;
		int cols = matrix[0].length - 1;
		while (topRow < bottomRow) {
			for (int i = 0; i <= cols; i++) {
				int temp = matrix[topRow][i];
				matrix[topRow][i] = matrix[bottomRow][i];
				matrix[bottomRow][i] = temp;
			}
			topRow++;
			bottomRow--;
		}
	}

	public static void swapDiagonalElements(int[][] matrix) {
		int cols = matrix[0].length;
		int col = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = col; j < cols; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			col++;
		}
	}

}
