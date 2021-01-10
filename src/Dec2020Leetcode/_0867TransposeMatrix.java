package Dec2020Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
		if (A == null || A.length == 0)
			return A;

		int rows = A.length - 1;
		int cols = A[0].length - 1;
		int[][] output = new int[cols + 1][rows + 1];

		Queue<Integer> q = new LinkedList<Integer>();
		int currCol = 0;
		while (currCol <= cols) {
			for (int i = 0; i <= rows; i++) {
				q.offer(A[i][currCol]);
			}
			currCol++;
		}

		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[0].length; j++) {
				output[i][j] = q.poll();
			}
		}
		return output;
	}
}
