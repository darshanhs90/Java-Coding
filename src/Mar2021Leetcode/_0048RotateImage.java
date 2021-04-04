package Mar2021Leetcode;

import java.util.Arrays;
import java.util.Stack;

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
		if (matrix == null || matrix.length == 0)
			return;

		int topRow = 0, bottomRow = matrix.length - 1;
		while (topRow < bottomRow) {
			swapRows(topRow, bottomRow, matrix);
			topRow++;
			bottomRow--;
		}

		for (int i = 0; i < matrix[0].length; i++) {
			swapDiagonals(0, i, matrix);
		}
		for (int i = 1; i < matrix.length; i++) {
			swapDiagonals(i, matrix[0].length - 1, matrix);
		}
		System.out.println(Arrays.deepToString(matrix));
	}

	public static void swapDiagonals(int startRow, int startCol, int[][] matrix) {
		Stack<Integer> stack = new Stack<Integer>();
		int row = startRow, col = startCol;
		while (row < matrix.length && col >= 0) {
			stack.push(matrix[row][col]);
			row++;
			col--;
		}

		row = startRow;
		col = startCol;
		while (row < matrix.length && col >= 0) {
			matrix[row][col] = stack.pop();
			row++;
			col--;
		}
	}

	public static void swapRows(int row1, int row2, int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			int temp = matrix[row1][i];
			matrix[row1][i] = matrix[row2][i];
			matrix[row2][i] = temp;
		}
	}

}
