package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _0857MinimumCostToHireKWorkers {
	public static void main(String[] args) {
		System.out.println(mincostToHireWorkers(new int[] { 10, 20, 5 }, new int[] { 70, 50, 30 }, 2));
		System.out.println(mincostToHireWorkers(new int[] { 3, 1, 10, 10, 1 }, new int[] { 4, 8, 2, 2, 7 }, 3));
	}

	public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
		Double[][] arr = new Double[quality.length][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Double[] { (double) wage[i] / (double) quality[i], (double) quality[i] };
		}

		Arrays.sort(arr, new Comparator<Double[]>() {

			@Override
			public int compare(Double[] o1, Double[] o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1[0], o2[0]);
			}
		});

		PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());

		double ans = Double.MAX_VALUE, res = 0;
		for (Double[] curr : arr) {
			res += curr[1];
			pq.offer(+curr[1]);

			if (pq.size() > K) {
				res -= pq.poll();
			}

			if (pq.size() == K) {
				ans = Math.min(ans, res * curr[0]);
			}
		}
		return ans;
	}

}
