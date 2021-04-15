package April2021Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class _0785IsGraphBiPartite {
	public static void main(String[] args) {
		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 0, 2 }, new int[] { 0, 1, 3 }, new int[] { 0, 2 } }));

		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 3 }, new int[] { 0, 2 }, new int[] { 1, 3 }, new int[] { 0, 2 } }));
	}

	public static boolean isBipartite(int[][] graph) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			map.put(i, new HashSet<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				map.get(i).add(graph[i][j]);
			}
		}

		HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (!colorMap.containsKey(entry.getKey())) {
				if (!dfs(entry.getKey(), map, colorMap, 1))
					return false;
			}
		}
		return true;
	}

	public static boolean dfs(int currNode, HashMap<Integer, HashSet<Integer>> map, HashMap<Integer, Integer> colorMap,
			int currColor) {
		if (colorMap.containsKey(currNode)) {
			if (colorMap.get(currNode) != currColor)
				return false;
			return true;
		}

		colorMap.put(currNode, currColor);
		int newColor = currColor == 1 ? 2 : 1;
		boolean out = true;
		Iterator<Integer> iter = map.get(currNode).iterator();
		while (iter.hasNext()) {
			out = out && dfs(iter.next(), map, colorMap, newColor);
			if (!out)
				return false;
		}
		return out;
	}
}
