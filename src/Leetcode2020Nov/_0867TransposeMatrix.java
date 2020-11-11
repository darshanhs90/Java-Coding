package Leetcode2020Nov;

import java.util.Arrays;

public class _0867TransposeMatrix {
	public static void main(String[] args) {
		int[][] out = transpose(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } });
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}

		out = transpose(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 } });
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}
	}

	public static int[][] transpose(int[][] A) {
		int newRows = A[0].length;
		int newCols = A.length;
		int[][] out = new int[newRows][newCols];
		int rowIndex = 0;
		int colIndex = 0;
		for (int i = 0; i < newCols; i++) {
			for (int j = 0; j < newRows; j++) {
				if (rowIndex >= newRows) {
					rowIndex = 0;
					colIndex++;
				}
				out[rowIndex][colIndex] = A[i][j];
				rowIndex++;
			}
		}
		return out;
	}
}
