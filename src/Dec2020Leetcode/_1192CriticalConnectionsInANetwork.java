package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _1192CriticalConnectionsInANetwork {
	public static void main(String[] args) {
		System.out.println(criticalConnections(4,
				new ArrayList<List<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(0, 1)),
						new ArrayList<Integer>(Arrays.asList(1, 2)), new ArrayList<Integer>(Arrays.asList(2, 0)),
						new ArrayList<Integer>(Arrays.asList(1, 3))))));
	}

	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();

		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		for (List<Integer> list : connections) {
			int source = list.get(0);
			int destination = list.get(1);
			graph.get(source).add(destination);
			graph.get(destination).add(source);
		}

		for (List<Integer> list : connections) {
			int source = list.get(0);
			int destination = list.get(1);
			graph.get(source).remove(Integer.valueOf(destination));
			graph.get(destination).remove(Integer.valueOf(source));
			HashSet<Integer> visited = new HashSet<Integer>();
			dfs(0, graph, visited);
			if (visited.size() != n) {
				output.add(new ArrayList<Integer>(Arrays.asList(source, destination)));

			}
			graph.get(source).add(destination);
			graph.get(destination).add(source);
		}
		return output;
	}
	
	public static void dfs(int source, HashMap<Integer, List<Integer>> graph, HashSet<Integer> visited) {
		if(visited.contains(source))
			return;
		visited.add(source);
		List<Integer> neighbors = graph.get(source);
		for(Integer neighbor : neighbors)
		{
			dfs(neighbor, graph, visited);
		}
	}
	

}
