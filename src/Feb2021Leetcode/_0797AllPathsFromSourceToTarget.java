package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _0797AllPathsFromSourceToTarget {
	public static void main(String[] args) {
		System.out.println(allPathsSourceTarget(
				new int[][] { new int[] { 1, 2 }, new int[] { 3 }, new int[] { 3 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(new int[][] { new int[] { 4, 3, 1 }, new int[] { 3, 2, 4 },
				new int[] { 3 }, new int[] { 4 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(new int[][] { new int[] { 1 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 2 }, new int[] { 3 }, new int[] {} }));

		System.out.println(allPathsSourceTarget(
				new int[][] { new int[] { 1, 3 }, new int[] { 2 }, new int[] { 3 }, new int[] {} }));

	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (graph == null || graph.length == 0)
			return output;
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			adjList.put(i, new ArrayList<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				adjList.get(i).add(graph[i][j]);
			}
		}
		dfs(0, adjList, new ArrayList<Integer>(Arrays.asList(0)), output,
				new HashSet<Integer>(new ArrayList<Integer>(Arrays.asList(0))));
		return output;
	}

	public static void dfs(int source, HashMap<Integer, List<Integer>> adjList, List<Integer> list,
			List<List<Integer>> output, HashSet<Integer> visited) {
		if (source == adjList.size() - 1) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		List<Integer> neighbors = adjList.get(source);
		for (Integer neighbor : neighbors) {
			if (!visited.contains(neighbor)) {
				visited.add(neighbor);
				list.add(neighbor);
				dfs(neighbor, adjList, list, output, visited);
				list.remove(Integer.valueOf(neighbor));
				visited.remove(neighbor);
			}

		}
	}

}
