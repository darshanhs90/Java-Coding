package May2021PrepLeetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class _0547NumberOfProvinces {

	public static void main(String[] args) {
		System.out.println(
				findCircleNum(new int[][] { new int[] { 1, 1, 0 }, new int[] { 1, 1, 0 }, new int[] { 0, 0, 1 } }));

		System.out.println(
				findCircleNum(new int[][] { new int[] { 1, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int findCircleNum(int[][] isConnected) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[0].length; j++) {
				if (!map.containsKey(i)) {
					map.put(i, new HashSet<Integer>());
				}

				if (!map.containsKey(j)) {
					map.put(j, new HashSet<Integer>());
				}

				if (isConnected[i][j] == 1 && i != j) {
					map.get(i).add(j);
					map.get(j).add(i);
				}
			}
		}

		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited.contains(i)) {
				count++;
				dfs(i, map, visited);
			}
		}
		return count;
	}

	public static void dfs(int source, HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> visited) {
		if (visited.contains(source))
			return;
		visited.add(source);
		Iterator<Integer> iter = map.get(source).iterator();
		while (iter.hasNext()) {
			dfs(iter.next(), map, visited);
		}
	}

}
