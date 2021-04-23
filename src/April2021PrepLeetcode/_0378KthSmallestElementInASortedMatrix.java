package April2021PrepLeetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _0378KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		System.out.println(kthSmallest(
				new int[][] { new int[] { 1, 5, 9 }, new int[] { 10, 11, 13 }, new int[] { 12, 13, 15 } }, 8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.offer(matrix[i][j]);
				if (pq.size() > k)
					pq.poll();
			}
		}
		return pq.peek();
	}

}
