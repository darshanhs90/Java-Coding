package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0815BusRoutes {
	public static void main(String[] args) {
		System.out.println(numBusesToDestination(new int[][] { new int[] { 1, 2, 7 }, new int[] { 3, 6, 7 } }, 1, 6));
	}

	public static int numBusesToDestination(int[][] routes, int S, int T) {
		HashMap<Integer, List<Integer>> busToStopMap = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, List<Integer>> stopToBusMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < routes.length; i++) {
			busToStopMap.put(i, new ArrayList<Integer>());
			for (int j = 0; j < routes[i].length; j++) {
				busToStopMap.get(i).add(routes[i][j]);

				if (!stopToBusMap.containsKey(routes[i][j])) {
					stopToBusMap.put(routes[i][j], new ArrayList<Integer>());
				}
				stopToBusMap.get(routes[i][j]).add(i);
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		HashSet<Integer> visited = new HashSet<Integer>();
		visited.add(S);

		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int busStop = q.poll();
				if (busStop == T)
					return count;

				List<Integer> buses = stopToBusMap.get(busStop);
				for (int bus : buses) {
					List<Integer> stops = busToStopMap.get(bus);
					for (int stop : stops) {
						if (!visited.contains(stop)) {
							q.offer(stop);
							visited.add(stop);
						}
					}
				}
			}
			count++;
		}
		return -1;
	}
}
