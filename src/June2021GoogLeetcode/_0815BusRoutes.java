package June2021GoogLeetcode;

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
		if (S == T)
			return 0;
		HashMap<Integer, HashSet<Integer>> busToBusStopMap = new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> busStopToBusMap = new HashMap<Integer, HashSet<Integer>>();

		for (int i = 0; i < routes.length; i++) {
			busToBusStopMap.put(i, new HashSet<Integer>());
			for (int stopNum : routes[i]) {
				busToBusStopMap.get(i).add(stopNum);

				if (!busStopToBusMap.containsKey(stopNum)) {
					busStopToBusMap.put(stopNum, new HashSet<Integer>());
				}
				busStopToBusMap.get(stopNum).add(i);
			}
		}

		int count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		q.offer(S);
		visited.add(S);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int stop = q.poll();
				if (stop == T)
					return count;

				// get all the buses this stop is part of
				// for all the buses add its stops
				Iterator<Integer> buses = busStopToBusMap.get(stop).iterator();
				while (buses.hasNext()) {
					int busNum = buses.next();
					Iterator<Integer> stops = busToBusStopMap.get(busNum).iterator();
					while (stops.hasNext()) {
						int currStop = stops.next();

						if (!visited.contains(currStop)) {
							visited.add(currStop);
							q.offer(currStop);
						}
					}
				}
			}
			count++;
		}
		return -1;
	}
}
