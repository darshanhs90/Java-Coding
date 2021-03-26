package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _0785IsGraphBiPartite {
	public static void main(String[] args) {
		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 0, 2 }, new int[] { 0, 1, 3 }, new int[] { 0, 2 } }));

		System.out.println(isBipartite(
				new int[][] { new int[] { 1, 3 }, new int[] { 0, 2 }, new int[] { 1, 3 }, new int[] { 0, 2 } }));
	}

	public static boolean isBipartite(int[][] graph) {
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();

		for (int i = 0; i < graph.length; i++) {
			adjList.put(i, new ArrayList<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
					adjList.get(i).add(graph[i][j]);
			}
		}
		boolean out = true;
		for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
			if (!color.containsKey(entry.getKey())) {
				out = out && dfs(entry.getKey(), adjList, color, 1);
			}
		}

		return out;
	}

	public static boolean dfs(int source, HashMap<Integer, List<Integer>> adjList, HashMap<Integer, Integer> color,
			int currColor) {
		if (color.containsKey(source) && color.get(source) != currColor)
			return false;
		if (color.containsKey(source))
			return true;
		color.put(source, currColor);

		List<Integer> list = adjList.get(source);
		boolean out = true;
		if (currColor == 1)
			currColor = 2;
		else
			currColor = 1;
		for (Integer newSrc : list) {
			out = out && dfs(newSrc, adjList, color, currColor);
		}
		return out;
	}
}
