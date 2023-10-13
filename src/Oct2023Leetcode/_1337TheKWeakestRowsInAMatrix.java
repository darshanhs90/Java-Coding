package Oct2023Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1337TheKWeakestRowsInAMatrix {
	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(kWeakestRows(
						new int[][] { new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 0 },
								new int[] { 1, 0, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 1 } },
						3)));

		System.out.println(Arrays.toString(kWeakestRows(new int[][] { new int[] { 1, 0, 0, 0 },
				new int[] { 1, 1, 1, 1 }, new int[] { 1, 0, 0, 0 }, new int[] { 1, 0, 0, 0 } }, 2)));

	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		
	}
}
