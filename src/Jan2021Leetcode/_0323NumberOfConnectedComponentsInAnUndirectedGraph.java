package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0323NumberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {
		System.out.println(
				countComponents(5, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 3, 4 } }));

		System.out.println(countComponents(5,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } }));

	}

	public static int countComponents(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dst = edges[i][1];
			map.get(src).add(dst);
			map.get(dst).add(src);
		}

		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(i, map, visited);
				count++;
			}
		}
		return count;
	}

	public static void dfs(int source, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
		if (visited.contains(source))
			return;
		visited.add(source);

		List<Integer> neighbors = map.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			dfs(neighbors.get(i), map, visited);
		}
	}

}
