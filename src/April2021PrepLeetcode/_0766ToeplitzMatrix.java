package April2021PrepLeetcode;

public class _0766ToeplitzMatrix {
	public static void main(String[] args) {
		System.out.println(isToeplitzMatrix(
				new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 1, 2, 3 }, new int[] { 9, 5, 1, 2 }, }));
		System.out.println(isToeplitzMatrix(new int[][] { new int[] { 1, 2 }, new int[] { 2, 2 }, }));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return true;
		for (int i = matrix.length - 1; i >= 0; i--) {
			if (!checkDiagonal(i, 0, matrix))
				return false;
		}
		for (int i = 1; i < matrix[0].length; i++) {
			if (!checkDiagonal(0, i, matrix))
				return false;
		}
		return true;
	}

	public static boolean checkDiagonal(int row, int col, int[][] matrix) {
		int val = matrix[row][col];
		while (row < matrix.length && col < matrix[0].length) {
			if (matrix[row][col] != val)
				return false;
			row++;
			col++;
		}
		return true;
	}
}
