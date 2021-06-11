package June2021GoogLeetcode;

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
			public int compare(int[] o1, int[] o2) {
				int dist1 = o1[0];
				int dist2 = o2[0];
				int noOfStations1 = o1[1];
				int noOfStations2 = o2[1];

				return (double) dist1 / (double) noOfStations1 > (double) dist2 / (double) noOfStations2 ? -1 : 1;
			}
		});

		for (int i = 0; i < stations.length - 1; i++) {
			pq.offer(new int[] { stations[i + 1] - stations[i], 1 });
		}

		while (k > 0) {
			int[] poll = pq.poll();
			poll[1] += 1;
			pq.offer(poll);
			k--;
		}
		int[] arr = pq.poll();
		return (double) arr[0] / (double) arr[1];

	}
}
