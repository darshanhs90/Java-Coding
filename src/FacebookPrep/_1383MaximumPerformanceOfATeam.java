package FacebookPrep;

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
		int[][] out = new int[n][2];
		for (int i = 0; i < out.length; i++) {
			out[i] = new int[] { speed[i], efficiency[i] };
		}

		Arrays.sort(out, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});

		long maxPerformance = Long.MIN_VALUE;

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> a - b);
		long currSpeed = 0;
		for (int i = 0; i < out.length; i++) {
			currSpeed += out[i][0];
			pq.offer(out[i][0]);

			if (pq.size() > k) {
				currSpeed -= pq.poll();
			}
			maxPerformance = Math.max(maxPerformance, currSpeed * out[i][1]);
		}
		return (int) (maxPerformance % (long) (1e9 + 7));
	}

}
