package Mar2021Leetcode;

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

		int cols = matrix[0].length;
		int rows = matrix.length;
		boolean reverse = true;
		for (int i = 0; i < cols; i++) {
			addDiagonals(0, i, matrix, reverse, list);
			reverse = !reverse;
		}

		for (int i = 1; i < rows; i++) {
			addDiagonals(i, cols - 1, matrix, reverse, list);
			reverse = !reverse;
		}

		int[] out = new int[list.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = list.get(i);
		}
		return out;
	}

	public static void addDiagonals(int currRow, int currCol, int[][] matrix, boolean reverse, List<Integer> list) {
		List<Integer> tempList = new ArrayList<Integer>();

		while (currRow < matrix.length && currCol >= 0) {
			tempList.add(matrix[currRow][currCol]);
			currRow++;
			currCol--;
		}

		if (reverse) {
			Collections.reverse(tempList);
		}

		list.addAll(tempList);
	}

}
