package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0815BusRoutes {
	public static void main(String[] args) {
		System.out.println(numBusesToDestination(new int[][] { new int[] { 1, 2, 7 }, new int[] { 3, 6, 7 } }, 1, 6));
		System.out.println(numBusesToDestination(new int[][] { new int[] { 7, 12 }, new int[] { 4, 5, 15 },
				new int[] { 6 }, new int[] { 15, 19 }, new int[] { 9, 12, 13 } }, 1, 6));
	}

	public static int numBusesToDestination(int[][] routes, int S, int T) {
		HashMap<Integer, List<Integer>> busToStopsMap = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, List<Integer>> stopsToBusMap = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < routes.length; i++) {
			busToStopsMap.put(i, new ArrayList<Integer>());
			for (int j = 0; j < routes[i].length; j++) {
				busToStopsMap.get(i).add(routes[i][j]);

				int busStop = routes[i][j];

				if (!stopsToBusMap.containsKey(busStop)) {
					stopsToBusMap.put(busStop, new ArrayList<Integer>());
				}
				stopsToBusMap.get(busStop).add(i);
			}
		}

		if (!stopsToBusMap.containsKey(S) || !stopsToBusMap.containsKey(T))
			return -1;

		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
		q.offer(S);
		HashSet<Integer> visitedStops = new HashSet<Integer>();
		visitedStops.add(S);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int src = q.poll();
				if (src == T)
					return count;

				if (!stopsToBusMap.containsKey(src))
					continue;
				List<Integer> buses = stopsToBusMap.get(src);

				for (Integer bus : buses) {
					List<Integer> stops = busToStopsMap.get(bus);

					for (Integer stop : stops) {
						if (!visitedStops.contains(stop)) {
							visitedStops.add(stop);
							q.offer(stop);
						}
					}
				}
			}
			count++;
		}

		return -1;
	}
}
