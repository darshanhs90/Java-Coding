package Jan2021Leetcode;

import java.util.ArrayList;
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
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < graph.length; i++) {
			List<Integer> neighborsList = new ArrayList<Integer>();
			int[] neighbors = graph[i];
			for (int j = 0; j < neighbors.length; j++) {
				neighborsList.add(neighbors[j]);
			}
			adjList.put(i, neighborsList);
		}

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		HashSet<Integer> visited = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		visited.add(0);
		list.add(0);
		dfs(0, adjList, output, list, visited);
		return output;
	}

	public static void dfs(int source, HashMap<Integer, List<Integer>> adjList, List<List<Integer>> output,
			List<Integer> list, HashSet<Integer> visited) {

		if (source == adjList.size() - 1) {
			output.add(new ArrayList<Integer>(list));
			return;
		}

		List<Integer> neighbors = adjList.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			Integer newSource = neighbors.get(i);
			if (!visited.contains(newSource)) {
				visited.add(newSource);
				list.add(newSource);
				dfs(newSource, adjList, output, list, visited);
				visited.remove(newSource);
				list.remove(Integer.valueOf(newSource));
			}
		}
	}

}
