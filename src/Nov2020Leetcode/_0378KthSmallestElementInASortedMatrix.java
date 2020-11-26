package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _0378KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		System.out.println(kthSmallest(
				new int[][] { new int[] { 1, 5, 9 }, new int[] { 10, 11, 13 }, new int[] { 12, 13, 15 } }, 8));

	}

	public static int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0)
			return -1;
		PriorityQueue<List<Integer>> q = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(2).compareTo(o2.get(2));
			}
		});

		for (int i = 0; i < matrix[0].length; i++) {
			q.offer(new ArrayList<Integer>(Arrays.asList(0, i, matrix[0][i])));
		}
		System.out.println(q);
		while (!q.isEmpty() && k > 1) {
			List<Integer> list = q.poll();
			int row = list.get(0);
			int col = list.get(1);
			if (row + 1 < matrix.length && col < matrix[0].length) {
				q.offer(new ArrayList<Integer>(Arrays.asList(row + 1, col, matrix[row + 1][col])));
			}
			k--;
		}
		return q.peek().get(2);
	}

}
