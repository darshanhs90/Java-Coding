package Jan2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0566ReshapeTheMatrix {
	public static void main(String[] args) {
		System.out.println(matrixReshape(new int[][] { new int[] { 1, 2 }, new int[] { 13, 4 } }, 1, 4));
	}

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		if (nums == null || nums.length == 0)
			return nums;
		int oldRows = nums.length;
		int oldCols = nums[0].length;
		if (r * c == oldCols * oldRows) {
			return fillNewMatrix(nums, r, c);
		}
		return nums;
	}

	public static int[][] fillNewMatrix(int[][] nums, int r, int c) {
		int[][] out = new int[r][c];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				q.offer(nums[i][j]);
			}
		}

		for (int i = 0; i < out.length; i++) {
			for (int j = 0; j < out[0].length; j++) {
				out[i][j] = q.poll();
			}
		}

		return out;
	}
}
