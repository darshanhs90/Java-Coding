package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1383MaximumPerformanceOfATeam {
	public static void main(String[] args) {
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 2));
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 3));
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 4));
	}

	public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		int[][] out = new int[speed.length][2];
		for (int i = 0; i < out.length; i++) {
			out[i] = new int[] { efficiency[i], speed[i] };
		}

		Arrays.sort(out, (a, b) -> b[0] - a[0]);
		System.out.println(Arrays.deepToString(out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer p1, Integer p2) {
				// TODO Auto-generated method stub
				return p1 - p2;
			}
		});

		long totalSum = 0;
		long res = 0;
		for (int i = 0; i < out.length; i++) {
			if (pq.size() == k) {
				totalSum -= pq.poll();
			}
			totalSum += out[i][1];
			pq.offer(out[i][1]);
			res = Math.max(res, totalSum * out[i][0]);
		}
		return (int) (res % (long) (1e9 + 7));
	}

}
