package Dec2020Leetcode;

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
		for (int i = 0; i < edges.length; i++) {
			int source = edges[i][0];
			int destination = edges[i][1];
			if (adjList.containsKey(source)) {
				adjList.get(source).add(destination);
			} else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(destination);
				adjList.put(source, set);
			}

			if (adjList.containsKey(destination)) {
				adjList.get(destination).add(source);
			} else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(source);
				adjList.put(destination, set);
			}
		}
				
		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(i, adjList, visited);
				count++;
			}
		}
		return count;
	}

	public static void dfs(int source, HashMap<Integer, HashSet<Integer>> adjList, HashSet<Integer> visited) {
		if (!adjList.containsKey(source) || visited.contains(source))
			return;
		visited.add(source);
		Iterator<Integer> iter = adjList.get(source).iterator();
		while (iter.hasNext()) {
			int nextNode = iter.next();
			if (!visited.contains(nextNode)) {
				dfs(nextNode, adjList, visited);
			}
		}
	}

}
