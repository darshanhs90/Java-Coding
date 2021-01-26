package Dec2020Leetcode;

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
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		boolean reverse = true;
		for (int i = 0; i < matrix[0].length; i++) {
			list = new ArrayList<Integer>();
			addDiagonal(0, i, matrix, list);
			if (reverse) {
				Collections.reverse(list);
				output.addAll(list);
			} else {
				output.addAll(list);
			}
			reverse = !reverse;
		}

		for (int i = 1; i < matrix.length; i++) {
			list = new ArrayList<Integer>();
			addDiagonal(i, matrix[0].length - 1, matrix, list);
			if (reverse) {
				Collections.reverse(list);
				output.addAll(list);
			} else {
				output.addAll(list);
			}
			reverse = !reverse;
		}

		int[] out = new int[output.size()];
		for (int i = 0; i < out.length; i++) {
			out[i] = output.get(i);
		}
		return out;
	}

	public static void addDiagonal(int x, int y, int[][] matrix, List<Integer> list) {
		while (x >= 0 && y >= 0 && y < matrix[0].length && x < matrix.length) {
			list.add(matrix[x][y]);
			x++;
			y--;
		}
	}

}
