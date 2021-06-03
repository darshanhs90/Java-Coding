package May2021GoogLeetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class _1057CampusBikes {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(assignBikes(new int[][] { new int[] { 0, 0 }, new int[] { 2, 1 } },
				new int[][] { new int[] { 1, 2 }, new int[] { 3, 3 } })));

		System.out.println(
				Arrays.toString(assignBikes(new int[][] { new int[] { 0, 0 }, new int[] { 1, 1 }, new int[] { 2, 0 } },
						new int[][] { new int[] { 1, 0 }, new int[] { 2, 2 }, new int[] { 2, 1 } })));
	}

	public static int[] assignBikes(int[][] workers, int[][] bikes) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int dist1 = o1[0];
				int dist2 = o2[0];
				int worker1 = o1[1];
				int worker2 = o2[1];
				int bike1 = o1[2];
				int bike2 = o2[2];

				if (dist1 == dist2) {
					if (worker1 == worker2) {
						return bike1 - bike2;
					}
					return worker1 - worker2;
				}
				return dist1 - dist2;
			}
		});

		for (int i = 0; i < workers.length; i++) {
			int xWorker = workers[i][0];
			int yWorker = workers[i][1];

			for (int j = 0; j < bikes.length; j++) {
				int xBike = bikes[j][0];
				int yBike = bikes[j][1];
				int dist = Math.abs(xWorker - xBike) + Math.abs(yWorker - yBike);
				pq.offer(new int[] { dist, i, j });
			}
		}

		int[] out = new int[workers.length];
		Arrays.fill(out, -1);
		HashSet<Integer> visited = new HashSet<Integer>();
		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			int workerNum = arr[1];
			int bikeNum = arr[2];

			if (out[workerNum] == -1 && !visited.contains(bikeNum)) {
				out[workerNum] = bikeNum;
				visited.add(bikeNum);
			}
		}
		return out;
	}
}
