package Feb2021Leetcode;

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
		HashMap<Integer, List<Integer>> busToStopsMap = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, List<Integer>> stopsToBusMap = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < routes.length; i++) {
			busToStopsMap.put(i, new ArrayList<Integer>());
			for (int j = 0; j < routes[i].length; j++) {
				int stopNum = routes[i][j];
				busToStopsMap.get(i).add(stopNum);

				if (!stopsToBusMap.containsKey(stopNum)) {
					stopsToBusMap.put(stopNum, new ArrayList<Integer>());
				}

				stopsToBusMap.get(stopNum).add(i);
			}
		}

		HashSet<Integer> stopsVisited = new HashSet<Integer>();
		int count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		
		while(!q.isEmpty())
		{
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int newStop = q.poll();
				
				if(newStop == T)
					return count;
				
				stopsVisited.add(newStop);
				
				
				//get all buses this is part of
				
				List<Integer> list = stopsToBusMap.get(newStop);
				for(Integer busNum : list)
				{
					List<Integer> stops = busToStopsMap.get(busNum);
					for(Integer stop: stops)
					{
						if(!stopsVisited.contains(stop))
						{
							stopsVisited.add(stop);
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
