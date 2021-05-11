package May2021Leetcode;

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
		List<Integer> list = new ArrayList<Integer>();
		boolean flip = true;
		for (int i = 0; i < matrix[0].length; i++) {
			list.addAll(traverse(0, i, flip, matrix));
			flip = !flip;
		}

		for (int i = 1; i < matrix.length; i++) {
			list.addAll(traverse(i, matrix[0].length - 1, flip, matrix));
			flip = !flip;
		}

		int[] out = new int[list.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = list.get(i);
		}
		return out;
	}

	public static List<Integer> traverse(int row, int col, boolean flip, int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		while (row < matrix.length && col >= 0) {
			list.add(matrix[row][col]);
			row++;
			col--;
		}
		if (flip)
			Collections.reverse(list);
		return list;
	}

}
