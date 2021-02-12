package Jan2021Leetcode;

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
		if(S == T)
			return 0;
		HashMap<Integer, List<Integer>> busToStopMap = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, List<Integer>> stopToBusMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < routes.length; i++) {
			int[] stops = routes[i];
			busToStopMap.put(i, new ArrayList<Integer>());
			for (int j = 0; j < stops.length; j++) {
				Integer stop = stops[j];
				busToStopMap.get(i).add(stop);

				if (!stopToBusMap.containsKey(stop)) {
					stopToBusMap.put(stop, new ArrayList<Integer>());
				}
				stopToBusMap.get(stop).add(i);
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visitedBuses = new HashSet<Integer>();
		List<Integer> buses = stopToBusMap.get(S);
		
		for (int i = 0; i < buses.size(); i++) {
			q.offer(buses.get(i));
			visitedBuses.add(buses.get(i));
		}

		int count = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Integer currBus = q.poll();

				if (busToStopMap.get(currBus).contains(T))
					return count;

				List<Integer> stops = busToStopMap.get(currBus);

				for (int j = 0; j < stops.size(); j++) {
					Integer currStop = stops.get(j);
					List<Integer> nextBuses = stopToBusMap.get(currStop);

					for (Integer nextBus : nextBuses) {
						if (!visitedBuses.contains(nextBus)) {
							q.offer(nextBus);
							visitedBuses.add(nextBus);
						}
					}
				}
			}
			count++;
		}
		return -1;
	}
}
