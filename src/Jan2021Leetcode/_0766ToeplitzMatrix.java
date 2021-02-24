package Jan2021Leetcode;

public class _0766ToeplitzMatrix {
	public static void main(String[] args) {
		System.out.println(isToeplitzMatrix(
				new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 1, 2, 3 }, new int[] { 9, 5, 1, 2 }, }));
		System.out.println(isToeplitzMatrix(new int[][] { new int[] { 1, 2 }, new int[] { 2, 2 }, }));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return false;
		int cols = matrix[0].length - 1;
		int rows = matrix.length - 1;

		for (int i = cols; i >= 0; i--) {
			if (!checkDiagonal(matrix, 0, i))
				return false;
		}
		for (int i = 1; i <= rows; i++) {
			if (!checkDiagonal(matrix, i, 0))
				return false;
		}
		return true;
	}

	public static boolean checkDiagonal(int[][] matrix, int row, int col) {
		int cols = matrix[0].length - 1;
		int rows = matrix.length - 1;
		int val = matrix[row][col];
		while (row <= rows && col <= cols) {
			if (val != matrix[row][col])
				return false;
			row += 1;
			col += 1;
		}
		return true;
	}
}
