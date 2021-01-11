package Dec2020Leetcode;

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

	static class Pair {
		int val, row;

		public Pair(int val, int row) {
			this.val = val;
			this.row = row;
		}
	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				if (o1.val == o2.val) {
					return o1.row - o2.row;
				}
				return o1.val - o2.val;
			}
		});

		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			for (int j = 0; j < mat[0].length; j++) {
				count += mat[i][j];
			}
			pq.offer(new Pair(count, i));
		}
		int[] out = new int[k];
		for (int i = 0; i < out.length; i++) {
			out[i] = pq.poll().row;
		}
		return out;
	}
}
