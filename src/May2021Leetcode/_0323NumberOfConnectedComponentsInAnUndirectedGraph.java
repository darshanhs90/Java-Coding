package May2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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

		for (int[] edge : edges) {
			int src = edge[0];
			int dst = edge[1];
			map.get(src).add(dst);
			map.get(dst).add(src);
		}

		HashSet<Integer> visited = new HashSet<Integer>();
		int count = 0;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				count++;
				dfs(entry.getKey(), map, visited);
			}
		}
		return count;
	}

	public static void dfs(int src, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
		if (visited.contains(src))
			return;
		visited.add(src);

		if (!map.containsKey(src))
			return;
		List<Integer> list = map.get(src);
		for (Integer newSrc : list) {
			dfs(newSrc, map, visited);
		}
	}

}
