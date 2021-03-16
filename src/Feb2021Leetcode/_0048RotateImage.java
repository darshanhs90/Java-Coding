package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		if (matrix == null || matrix.length < 2)
			return;
		int topRow = 0, bottomRow = matrix.length - 1;
		while (topRow < bottomRow) {
			swapRows(topRow, bottomRow, matrix);
			topRow++;
			bottomRow--;
		}

		for (int i = 0; i < matrix[0].length; i++) {
			swapDiagonalElements(0, i, matrix);
		}

		for (int i = 1; i < matrix.length; i++) {
			swapDiagonalElements(i, matrix[0].length - 1, matrix);
		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	public static void swapDiagonalElements(int row, int col, int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int currRow = row, currCol = col;
		while (currRow >= 0 && currCol >= 0 && currRow < matrix.length) {
			list.add(matrix[currRow][currCol]);
			currRow++;
			currCol--;
		}
		Collections.reverse(list);
		int index = 0;
		currRow = row;
		currCol = col;
		while (currRow >= 0 && currCol >= 0 && currRow < matrix.length) {
			matrix[currRow][currCol] = list.get(index);
			index++;
			currRow++;
			currCol--;
		}
	}

	public static void swapRows(int topRow, int bottomRow, int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			int temp = matrix[topRow][i];
			matrix[topRow][i] = matrix[bottomRow][i];
			matrix[bottomRow][i] = temp;
		}
	}

}
