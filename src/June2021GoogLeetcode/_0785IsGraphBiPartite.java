package June2021GoogLeetcode;

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

	public static boolean dfs(int src, HashMap<Integer, HashSet<Integer>> map, HashMap<Integer, Integer> colorMap,
			int currColor) {
		if (colorMap.containsKey(src)) {
			return colorMap.get(src) == currColor;
		}

		int newColor = currColor == 1 ? 2 : 1;

		colorMap.put(src, currColor);

		Iterator<Integer> iter = map.get(src).iterator();
		while (iter.hasNext()) {
			if (!dfs(iter.next(), map, colorMap, newColor))
				return false;
		}
		return true;
	}

}
