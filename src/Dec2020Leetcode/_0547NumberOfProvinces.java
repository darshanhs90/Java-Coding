package Dec2020Leetcode;

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
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1) {
					int source = i;
					int destination = j;
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

		System.out.println(map);
		int count = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				visited.add(entry.getKey());
				count++;
				List<Integer> values = entry.getValue();
				for (Integer val : values) {
					dfs(val, visited, map);
				}
			}
		}

		return count;
	}

	public static void dfs(Integer key, HashSet<Integer> set, HashMap<Integer, List<Integer>> map) {
		if (set.contains(key))
			return;
		set.add(key);
		List<Integer> values = map.get(key);
		for (Integer val : values) {
			dfs(val, set, map);
		}
	}

}
