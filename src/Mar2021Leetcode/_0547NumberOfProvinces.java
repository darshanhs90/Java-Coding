package Mar2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class _0547NumberOfProvinces {

	public static void main(String[] args) {
		System.out.println(
				findCircleNum(new int[][] { new int[] { 1, 1, 0 }, new int[] { 1, 1, 0 }, new int[] { 0, 0, 1 } }));

		System.out.println(
				findCircleNum(new int[][] { new int[] { 1, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int findCircleNum(int[][] isConnected) {
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				if (isConnected[i][j] == 1) {
					if (!adjList.containsKey(i)) {
						adjList.put(i, new HashSet<Integer>());
					}

					if (!adjList.containsKey(j)) {
						adjList.put(j, new HashSet<Integer>());
					}

					adjList.get(i).add(j);
					adjList.get(j).add(i);
				}
			}
		}
		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : adjList.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				dfs(entry.getKey(), adjList, visited);
				count++;
			}
		}
		return count;
	}

	public static void dfs(int src, HashMap<Integer, HashSet<Integer>> adjList, HashSet<Integer> visited) {
		if (visited.contains(src)) {
			return;
		}

		visited.add(src);
		if (!adjList.containsKey(src))
			return;
		Iterator<Integer> iter = adjList.get(src).iterator();
		while (iter.hasNext()) {
			dfs(iter.next(), adjList, visited);
		}
	}

}
