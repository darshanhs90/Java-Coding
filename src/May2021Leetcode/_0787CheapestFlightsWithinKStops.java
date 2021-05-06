package May2021Leetcode;

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

	static class Pair {
		int src, dist;

		public Pair(int src, int dist) {
			this.src = src;
			this.dist = dist;
		}
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 0; i < flights.length; i++) {
			int currSrc = flights[i][0];
			int currDst = flights[i][1];
			int dist = flights[i][2];

			if (!map.containsKey(currSrc)) {
				map.put(currSrc, new HashMap<Integer, Integer>());
			}

			if (!map.containsKey(currDst)) {
				map.put(currDst, new HashMap<Integer, Integer>());
			}

			map.get(currSrc).put(currDst, dist);
			map.get(currDst).put(currSrc, dist);
		}

		int minDistance = Integer.MAX_VALUE;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(src, 0));
		while (K >= -1 && !q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pollVal = q.poll();
				int currSrc = pollVal.src;
				if (currSrc == dst) {
					minDistance = Math.min(minDistance, pollVal.dist);
					continue;
				}

				if (!map.containsKey(currSrc))
					continue;
				HashMap<Integer, Integer> temp = map.get(currSrc);
				for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
					q.offer(new Pair(entry.getKey(), pollVal.dist + entry.getValue()));
				}
			}
			K--;
		}
		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}
}
