package Dec2020Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

public class _0882ReachableNodesInSubdividedGraph {

	public static void main(String[] args) {
		System.out.println(reachableNodes(
				new int[][] { new int[] { 0, 1, 10 }, new int[] { 0, 2, 1 }, new int[] { 1, 2, 2 } }, 6, 3));

		System.out.println(reachableNodes(new int[][] { new int[] { 0, 1, 4 }, new int[] { 1, 2, 6 },
				new int[] { 0, 2, 8 }, new int[] { 1, 3, 1 } }, 10, 4));
	}

	public static int reachableNodes(int[][] edges, int M, int N) {
		HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 0; i < edges.length; i++) {
			int[] arr = edges[i];
			int source = arr[0];
			int destination = arr[1];
			int cost = arr[2];
			if (graph.containsKey(source)) {
				graph.get(source).put(destination, cost);
			} else {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(destination, cost);
				graph.put(source, map);
			}

			if (graph.containsKey(destination)) {
				graph.get(destination).put(source, cost);
			} else {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(source, cost);
				graph.put(destination, map);
			}
		}
		TreeSet<String> visited = new TreeSet<String>();
		dfs(0, M, graph, visited, new HashSet<Integer>());
		return visited.size() - 1;
	}

	public static void dfs(int source, int M, HashMap<Integer, HashMap<Integer, Integer>> graph,
			TreeSet<String> visitedStrings, HashSet<Integer> visitedMainNodes) {
		if (M < 0 || visitedMainNodes.contains(source))
			return;
		if (graph.containsKey(source)) {
			HashMap<Integer, Integer> nextNodes = graph.get(source);
			visitedMainNodes.add(source);
			visitedStrings.add(source + "");
			for (Map.Entry<Integer, Integer> entry : nextNodes.entrySet()) {
				Integer dest = entry.getKey();
				int cost = entry.getValue();
				if (cost <= M) {
					addAllString(source, dest, cost, visitedStrings);
					visitedMainNodes.add(source);
					dfs(dest, M - cost - 1, graph, visitedStrings, visitedMainNodes);
					visitedMainNodes.remove(source);
				} else {
					addSomeString(source, dest, M, cost, visitedStrings);
				}
			}
			visitedMainNodes.remove(source);
		}
	}

	public static void addAllString(int source, int destination, int cost, TreeSet<String> visitedStrings) {
		int min = Math.min(source, destination);
		int max = Math.max(source, destination);
		if (source > destination) {
			for (int i = cost - 1; i >= 0; i--) {
				visitedStrings.add(min + "->" + max + "<->" + i);
			}
		} else {
			for (int i = 0; i < cost; i++) {
				visitedStrings.add(min + "->" + max + "<->" + i);
			}
		}
	}

	public static void addSomeString(int source, int destination, int M, int maxCost, TreeSet<String> visitedStrings) {
		int min = Math.min(source, destination);
		int max = Math.max(source, destination);
		if (source > destination) {
			for (int i = maxCost; i >= maxCost - M; i--) {
				visitedStrings.add(min + "->" + max + "<->" + i);
			}
		} else {
			for (int i = 0; i < M; i++) {
				visitedStrings.add(min + "->" + max + "<->" + i);
			}
		}
	}

}
