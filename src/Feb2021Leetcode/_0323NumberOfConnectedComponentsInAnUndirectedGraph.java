package Feb2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _0323NumberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {
		System.out.println(
				countComponents(5, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 3, 4 } }));

		System.out.println(countComponents(5,
				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } }));

	}

	public static int countComponents(int n, int[][] edges) {
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < n; i++) {
			adjList.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int src = edges[i][0];
			int dst = edges[i][1];
			adjList.get(src).add(dst);
			adjList.get(dst).add(src);
		}

		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				count++;
				dfs(i, adjList, visited);
			}
		}
		return count;
	}

	public static void dfs(int src, HashMap<Integer, HashSet<Integer>> adjList, HashSet<Integer> visited) {
		if (visited.contains(src))
			return;
		visited.add(src);
		Iterator<Integer> iter = adjList.get(src).iterator();
		while (iter.hasNext()) {
			dfs(iter.next(), adjList, visited);
		}
	}

}
