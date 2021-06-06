package June2021GoogLeetcode;

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

	// 1 2 3
	// 4 5 6
	// 7 8 9

	// 7 8 9
	// 4 5 6
	// 1 2 3
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int topRow = 0, bottomRow = matrix.length - 1;
		while (topRow < bottomRow) {
			swapRow(topRow, bottomRow, matrix);
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

	public static void swapDiagonals(int row, int col, int[][] matrix) {
		Stack<Integer> stack = new Stack<Integer>();
		int currRow = row, currCol = col;
		while (currRow < matrix.length && currCol >= 0) {
			stack.push(matrix[currRow][currCol]);
			currRow++;
			currCol--;
		}

		currRow = row;
		currCol = col;
		while (currRow < matrix.length && currCol >= 0) {
			matrix[currRow][currCol] = stack.pop();
			currRow++;
			currCol--;
		}
	}

	public static void swapRow(int top, int bottom, int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			int val = matrix[top][i];
			matrix[top][i] = matrix[bottom][i];
			matrix[bottom][i] = val;
		}
	}

}
