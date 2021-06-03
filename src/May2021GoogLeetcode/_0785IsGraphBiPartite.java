package May2021GoogLeetcode;

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
				if (!dfs(entry.getKey(), map, colorMap, 1))
					return false;
			}
		}
		return true;
	}

	public static boolean dfs(int src, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> colorMap,
			int color) {
		if (colorMap.containsKey(src)) {
			return colorMap.get(src) == color;
		}

		colorMap.put(src, color);

		int newColor = color == 1 ? 2 : 1;

		if (!map.containsKey(src)) {
			return true;
		}

		List<Integer> list = map.get(src);
		for (Integer newSrc : list) {
			if (!dfs(newSrc, map, colorMap, newColor))
				return false;
		}
		return true;
	}

}
