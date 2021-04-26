package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0785IsGraphBiPartite {
	public static void main(String[] args) {
		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 0, 2 }, new int[] { 0, 1, 3 }, new int[] { 0, 2 } }));

		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 3 }, new int[] { 0, 2 }, new int[] { 1, 3 }, new int[] { 0, 2 } }));
	}

	public static boolean isBipartite(int[][] graph) {
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				int src = i;
				int dst = graph[i][j];
				if (!map.containsKey(src)) {
					map.put(src, new ArrayList<Integer>());
				}
				map.get(src).add(dst);
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (!colorMap.containsKey(entry.getKey())) {
				if (!dfs(entry.getKey(), map, colorMap, 1)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean dfs(int source, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> colorMap,
			int currColor) {
		if (colorMap.containsKey(source)) {
			return colorMap.get(source) == currColor;
		}

		colorMap.put(source, currColor);
		currColor = currColor == 1 ? 2 : 1;

		if (!map.containsKey(source))
			return true;
		List<Integer> neighbors = map.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			int newSrc = neighbors.get(i);
			if (!dfs(newSrc, map, colorMap, currColor))
				return false;
		}
		return true;
	}

}
