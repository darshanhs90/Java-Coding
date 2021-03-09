package Feb2021Leetcode;

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
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, Integer> nodeVal = new HashMap<Integer, Integer>();
		for (int i = 0; i < graph.length; i++) {
			adjList.put(i, new ArrayList<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				adjList.get(i).add(graph[i][j]);
			}
		}

		boolean out = true;
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			if (!nodeVal.containsKey(entry.getKey())) {
				out = out && populateNodeMap(entry.getKey(), adjList, nodeVal, 1);
			}
		}
		return out;
	}

	public static boolean populateNodeMap(int source, HashMap<Integer, List<Integer>> adjList,
			HashMap<Integer, Integer> nodeVal, int color) {
		if (nodeVal.containsKey(source) && nodeVal.get(source) != color)
			return false;

		if (nodeVal.containsKey(source))
			return true;

		nodeVal.put(source, color);
		boolean out = true;
		int newColor = color == 1 ? 2 : 1;
		List<Integer> neighbors = adjList.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			out = out && populateNodeMap(neighbors.get(i), adjList, nodeVal, newColor);
		}
		return out;
	}
}
