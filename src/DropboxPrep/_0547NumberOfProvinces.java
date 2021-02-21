package DropboxPrep;

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
				if (isConnected[i][j] == 1) {
					Integer source = i;
					Integer destination = j;

					if (map.containsKey(source)) {
						map.get(source).add(destination);
					} else {
						List<Integer> list = new ArrayList<Integer>();
						list.add(destination);
						map.put(source, list);
					}
				}
			}
		}

		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int source = entry.getKey();
			if (!visited.contains(source)) {
				dfs(source, map, visited);
				count++;
			}
		}
		return count;
	}

	public static void dfs(int source, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
		if (visited.contains(source))
			return;

		visited.add(source);
		List<Integer> list = map.get(source);
		for (int i = 0; i < list.size(); i++) {
			dfs(list.get(i), map, visited);
		}
	}

}
