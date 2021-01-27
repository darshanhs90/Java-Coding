package Dec2020Leetcode;

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
		HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			adjList.put(i, new ArrayList<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				adjList.get(i).add(graph[i][j]);
			}
		}

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		dfs(0, adjList, new ArrayList<Integer>(Arrays.asList(0)), output, new HashSet<Integer>());
		return output;
	}

	public static void dfs(int source, HashMap<Integer, ArrayList<Integer>> adjList, List<Integer> list,
			List<List<Integer>> output, HashSet<Integer> visited) {
		if (visited.contains(source))
			return;
		if (source == adjList.size() - 1) {
			output.add(new ArrayList<Integer>(list));
			return;
		}
		visited.add(source);
		List<Integer> neighbors = adjList.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			Integer nextNode = neighbors.get(i);
			list.add(nextNode);
			dfs(nextNode, adjList, list, output, visited);
			list.remove(Integer.valueOf(nextNode));
		}
		list.remove(Integer.valueOf(source));
		visited.remove(source);
	}

}
