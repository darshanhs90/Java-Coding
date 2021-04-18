package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _0547NumberOfProvinces {

	public static void main(String[] args) {
		System.out.println(
				findCircleNum(new int[][] { new int[] { 1, 1, 0 }, new int[] { 1, 1, 0 }, new int[] { 0, 0, 1 } }));

		System.out.println(
				findCircleNum(new int[][] { new int[] { 1, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 } }));
	}

	public static int findCircleNum(int[][] isConnected) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[0].length; j++) {
				if (!map.containsKey(i)) {
					map.put(i, new ArrayList<Integer>());
				}

				if (!map.containsKey(j)) {
					map.put(j, new ArrayList<Integer>());
				}

				if (isConnected[i][j] == 1) {
					map.get(i).add(j);
					map.get(j).add(i);
				}
			}
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
		List<Integer> list = map.get(src);
		for (Integer newSrc : list) {
			dfs(newSrc, map, visited);
		}
	}

}
