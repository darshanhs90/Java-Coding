package April2021PrepLeetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0787CheapestFlightsWithinKStops {
	public static void main(String[] args) {
		System.out.println(findCheapestPrice(3,
				new int[][] { new int[] { 0, 1, 100 }, new int[] { 1, 2, 100 }, new int[] { 0, 2, 500 } }, 0, 2, 1));

		System.out.println(findCheapestPrice(3,
				new int[][] { new int[] { 0, 1, 200 }, new int[] { 1, 2, 100 }, new int[] { 0, 2, 500 } }, 0, 2, 0));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		HashMap<Integer, HashMap<Integer, Integer>> adjList = new HashMap<Integer, HashMap<Integer, Integer>>();

		for (int i = 0; i < n; i++) {
			adjList.put(i, new HashMap<Integer, Integer>());
		}

		for (int i = 0; i < flights.length; i++) {
			int[] arr = flights[i];
			int currSrc = arr[0];
			int currDst = arr[1];
			int dist = arr[2];
			adjList.get(currSrc).put(currDst, dist);
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { src, 0 });
		int outDistance = Integer.MAX_VALUE;
		while (!q.isEmpty() && K >= -1) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				int currSrc = arr[0];
				int currDist = arr[1];

				if (currSrc == dst) {
					outDistance = Math.min(currDist, outDistance);
					continue;
				}

				HashMap<Integer, Integer> map = adjList.get(currSrc);

				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					q.offer(new int[] { entry.getKey(), entry.getValue() + currDist });
				}
			}

			K--;
		}

		return outDistance == Integer.MAX_VALUE ? -1 : outDistance;
	}
}
