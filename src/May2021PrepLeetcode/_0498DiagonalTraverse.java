package May2021PrepLeetcode;

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

		boolean flip = true;
		for (int i = 0; i < matrix[0].length; i++) {
			addDiagonals(0, i, matrix, flip, output);
			flip = !flip;
		}

		for (int i = 1; i < matrix.length; i++) {
			addDiagonals(i, matrix[0].length - 1, matrix, flip, output);
			flip = !flip;
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}

	public static void addDiagonals(int startRow, int startCol, int[][] matrix, boolean flip, List<Integer> output) {
		List<Integer> list = new ArrayList<Integer>();
		while (startRow < matrix.length && startCol >= 0) {
			list.add(matrix[startRow][startCol]);
			startRow++;
			startCol--;
		}

		if (flip)
			Collections.reverse(list);

		output.addAll(list);
	}

}
