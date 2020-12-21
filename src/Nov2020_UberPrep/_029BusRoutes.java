package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _029BusRoutes {

	public static void main(String[] args) {
		System.out.println(numBusesToDestination(new int[][] { new int[] { 1, 2, 7 }, new int[] { 3, 6, 7 } }, 1, 6));
	}

	static class Pair {
		int val, depth;

		public Pair(int val, int depth) {
			this.val = val;
			this.depth = depth;
		}
	}

	public static int numBusesToDestination(int[][] routes, int S, int T) {
		if (S == T)
			return 0;
		List<List<Integer>> routesGraph = new ArrayList<List<Integer>>();

		for (int i = 0; i < routes.length; i++) {
			Arrays.sort(routes[i]);
			routesGraph.add(new ArrayList<Integer>());
		}

		HashSet<Integer> visited = new HashSet<Integer>();
		List<Integer> target = new ArrayList<Integer>();
		Queue<Pair> q = new LinkedList<Pair>();

		for (int i = 0; i < routes.length; i++) {
			if (Arrays.binarySearch(routes[i], S) >= 0) {
				visited.add(i);
				q.offer(new Pair(i, 0));
			}
			if (Arrays.binarySearch(routes[i], T) >= 0) {
				target.add(i);
			}

			for (int j = i + 1; j < routes.length; j++) {
				if (routesIntersect(routes[i], routes[j])) {
					routesGraph.get(i).add(j);
					routesGraph.get(j).add(i);
				}
			}
		}

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int bus = p.val, depth = p.depth;
			if (target.contains(bus))
				return depth + 1;
			for (int i = 0; i < routesGraph.get(bus).size(); i++) {
				if (!visited.contains(routesGraph.get(bus).get(i))) {
					visited.add(routesGraph.get(bus).get(i));
					q.offer(new Pair(routesGraph.get(bus).get(i), depth + 1));
				}
			}

		}

		return -1;
	}

	public static boolean routesIntersect(int[] A, int[] B) {
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] == B[j])
				return true;
			if (A[i] < B[j])
				i++;
			else
				j++;
		}

		return false;
	}

}
