package May2021GoogLeetcode;

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
		List<Integer> out = new ArrayList<Integer>();
		boolean flip = true;
		for (int i = 0; i < matrix[0].length; i++) {
			traverse(0, i, matrix, flip, out);
			flip = !flip;
		}
		for (int i = 1; i < matrix.length; i++) {
			traverse(i, matrix[0].length - 1, matrix, flip, out);
			flip = !flip;
		}

		int[] output = new int[out.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = out.get(i);
		}
		return output;
	}

	public static void traverse(int row, int col, int[][] matrix, boolean flip, List<Integer> list) {
		List<Integer> tempList = new ArrayList<Integer>();
		while (row < matrix.length && col >= 0) {
			tempList.add(matrix[row][col]);
			row++;
			col--;
		}
		if (flip)
			Collections.reverse(tempList);

		list.addAll(tempList);
	}

}
