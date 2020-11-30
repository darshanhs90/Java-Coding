package Nov2020_GoogPrep;

public class _010RotateImage {

	public static void main(String[] args) {
		rotate(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } });
		rotate(new int[][] { new int[] { 5, 1, 9, 11 }, new int[] { 2, 4, 8, 10 }, new int[] { 13, 3, 6, 7 },
				new int[] { 15, 14, 12, 16 } });
		rotate(new int[][] { new int[] { 1 } });
		rotate(new int[][] { new int[] { 1, 2 }, new int[] { 3, 4 } });
	}

	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int rows = matrix.length;
		for (int i = 0; i < matrix[0].length; i++) {
			int topRow = 0;
			int bottomRow = rows - 1;
			while (topRow < bottomRow) {
				int temp = matrix[topRow][i];
				matrix[topRow][i] = matrix[bottomRow][i];
				matrix[bottomRow][i] = temp;
				topRow++;
				bottomRow--;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
