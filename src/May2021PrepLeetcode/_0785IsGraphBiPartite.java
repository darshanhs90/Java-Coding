package May2021PrepLeetcode;

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
		for (int i = 0; i < graph.length; i++) {
			map.put(i, new ArrayList<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				map.get(i).add(graph[i][j]);
			}
		}

		HashMap<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			if (!colorMap.containsKey(entry.getKey())) {
				if (!isBipartite(entry.getKey(), map, colorMap, 1)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isBipartite(int source, HashMap<Integer, List<Integer>> map,
			HashMap<Integer, Integer> colorMap, int currColor) {
		if (colorMap.containsKey(source)) {
			if (colorMap.get(source) != currColor)
				return false;
			return true;
		}

		colorMap.put(source, currColor);
		int newColor = currColor == 1 ? 2 : 1;

		List<Integer> neighbors = map.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			if (!isBipartite(neighbors.get(i), map, colorMap, newColor))
				return false;
		}
		return true;
	}

}
