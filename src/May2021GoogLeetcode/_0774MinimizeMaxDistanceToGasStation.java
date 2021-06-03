package May2021GoogLeetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0774MinimizeMaxDistanceToGasStation {
	public static void main(String[] args) {
		System.out.println(minmaxGasDist(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 9));
		System.out.println(minmaxGasDist(new int[] { 23, 24, 36, 39, 46, 56, 57, 65, 84, 98 }, 1));
	}

	public static double minmaxGasDist(int[] stations, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return (double) b[0] / b[1] < (double) a[0] / a[1] ? -1 : 1;
			}
		});

		for (int i = 0; i < stations.length - 1; i++) {
			pq.offer(new int[] { stations[i + 1] - stations[i], 1 });
		}

		for (int i = 0; i < k; i++) {
			int[] arr = pq.poll();
			arr[1] += 1;
			pq.offer(arr);
		}
		int[] arr = pq.poll();
		return (double) arr[0] / (double) arr[1];

	}
}
