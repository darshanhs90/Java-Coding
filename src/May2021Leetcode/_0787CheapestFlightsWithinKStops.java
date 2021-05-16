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
		int src;
		int dist;

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

			map.get(currSrc).put(currDst, dist);
		}

		int minDistance = Integer.MAX_VALUE;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(src, 0));

		while (!q.isEmpty() && K >= -1) {
			int size = q.size();
			for (int i = 0; i < size; i++) {

				Pair pair = q.poll();
				if (pair.src == dst) {
					minDistance = Math.min(minDistance, pair.dist);
					continue;
				}

				if (!map.containsKey(pair.src))
					continue;
				HashMap<Integer, Integer> tempMap = map.get(pair.src);

				for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
					q.offer(new Pair(entry.getKey(), pair.dist + entry.getValue()));
				}
			}
			K--;
		}

		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}
}
