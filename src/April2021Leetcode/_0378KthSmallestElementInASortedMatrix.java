package April2021Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0378KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		System.out.println(kthSmallest(
				new int[][] { new int[] { 1, 5, 9 }, new int[] { 10, 11, 13 }, new int[] { 12, 13, 15 } }, 8));
	}

	static class Pair {
		int x, y, val;

		public Pair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;

		}
	}

	public static int kthSmallest(int[][] matrix, int k) {
		
	}

}
