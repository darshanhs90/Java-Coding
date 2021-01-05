package Dec2020Leetcode;

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
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
		});

		for (int i = 0; i < Math.min(matrix.length, k); i++) {
			pq.offer(new Pair(i, 0, matrix[i][0]));
		}

		Pair p = pq.peek();
		while (k > 0) {

			p = pq.poll();
			if (p.y < matrix[0].length - 1) {
				pq.offer(new Pair(p.x, p.y + 1, matrix[p.x][p.y + 1]));
			}
			k--;
		}
		return p.val;
	}

}
