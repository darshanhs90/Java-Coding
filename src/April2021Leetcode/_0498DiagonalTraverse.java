package April2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0498DiagonalTraverse {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findDiagonalOrder(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } })));
	}

	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new int[] {};
		List<Integer> list = new ArrayList<Integer>();
		boolean flip = true;
		for (int i = 0; i < matrix[0].length; i++) {
			addDiagonal(0, i, matrix, list, flip);
			flip = !flip;
		}

		for (int i = 1; i < matrix.length; i++) {
			addDiagonal(i, matrix[0].length - 1, matrix, list, flip);
			flip = !flip;
		}

		int[] out = new int[list.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = list.get(i);
		}
		return out;
	}

	public static void addDiagonal(int row, int col, int[][] matrix, List<Integer> list, boolean flip) {
		List<Integer> tempList = new ArrayList<Integer>();
		while (row >= 0 && col >= 0 && row < matrix.length && col <= matrix[0].length) {
			tempList.add(matrix[row][col]);
			row++;
			col--;
		}

		if (flip) {
			Collections.reverse(tempList);
		}
		list.addAll(tempList);
	}

}
