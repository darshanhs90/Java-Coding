package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class _0815BusRoutes {
	public static void main(String[] args) {
		System.out.println(numBusesToDestination(new int[][] { new int[] { 1, 2, 7 }, new int[] { 3, 6, 7 } }, 1, 6));
	}

	public static int numBusesToDestination(int[][] routes, int S, int T) {
		HashMap<Integer, HashSet<Integer>> busToStopMap = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> stopToBusMap = new HashMap<Integer, HashSet<Integer>>();

		Queue<Integer> busesQ = new LinkedList<Integer>();
		for (int i = 0; i < routes.length; i++) {
			int busId = i;
			busToStopMap.put(i, new HashSet<Integer>());
			for (int j = 0; j < routes[i].length; j++) {
				int stop = routes[i][j];
				if (stop == S) {
					busesQ.add(busId);
				}
				busToStopMap.get(i).add(stop);

				if (!stopToBusMap.containsKey(stop)) {
					stopToBusMap.put(stop, new HashSet<Integer>());
				}
				stopToBusMap.get(stop).add(busId);
			}
		}

		if (S == T)
			return 0;
		HashSet<Integer> visitedBuses = new HashSet<Integer>();

		int level = 1;
		while (!busesQ.isEmpty()) {
			int size = busesQ.size();
			for (int i = 0; i < size; i++) {
				int busId = busesQ.poll();
				if (busToStopMap.get(busId).contains(T))
					return level;
				visitedBuses.add(busId);

				Iterator<Integer> neighboringStops = busToStopMap.get(busId).iterator();
				while (neighboringStops.hasNext()) {
					int nextStop = neighboringStops.next();
					Iterator<Integer> stopsBuses = stopToBusMap.get(nextStop).iterator();
					while (stopsBuses.hasNext()) {
						int nextBus = stopsBuses.next();
						if (!visitedBuses.contains(nextBus)) {
							busesQ.add(nextBus);
						}
					}
				}
			}
			level++;
		}
		return -1;
	}
}
