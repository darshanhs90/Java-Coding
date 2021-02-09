package Jan2021Leetcode;

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
		List<Integer> output = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return new int[] {};
		boolean reverse = true;
		for (int i = 0; i < matrix[0].length; i++) {
			addDiagonal(0, i, matrix, output, reverse);
			reverse = !reverse;
		}
		for (int i = 1; i < matrix.length; i++) {
			addDiagonal(i, matrix[0].length - 1, matrix, output, reverse);
			reverse = !reverse;
		}
		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}

	public static void addDiagonal(int row, int col, int[][] matrix, List<Integer> list, boolean reverse) {
		List<Integer> tempList = new ArrayList<Integer>();

		while (row < matrix.length && col >= 0) {
			tempList.add(matrix[row][col]);
			row++;
			col--;
		}

		if (reverse)
			Collections.reverse(tempList);

		list.addAll(tempList);
	}

}
