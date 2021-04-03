package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _0399EvaluateDivision {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<List<String>>();
		equations.add(new ArrayList<String>(Arrays.asList("a", "b")));
		equations.add(new ArrayList<String>(Arrays.asList("b", "c")));
		List<List<String>> queries = new ArrayList<List<String>>();
		queries.add(new ArrayList<String>(Arrays.asList("a", "c")));
		queries.add(new ArrayList<String>(Arrays.asList("b", "a")));
		queries.add(new ArrayList<String>(Arrays.asList("a", "e")));
		queries.add(new ArrayList<String>(Arrays.asList("a", "a")));
		queries.add(new ArrayList<String>(Arrays.asList("x", "x")));
		System.out.println(Arrays.toString(calcEquation(equations, new double[] { 2.0, 3.0 }, queries)));

		equations = new ArrayList<List<String>>();
		equations.add(new ArrayList<String>(Arrays.asList("a", "b")));
		equations.add(new ArrayList<String>(Arrays.asList("b", "c")));
		equations.add(new ArrayList<String>(Arrays.asList("bc", "cd")));
		queries = new ArrayList<List<String>>();
		queries.add(new ArrayList<String>(Arrays.asList("a", "c")));
		queries.add(new ArrayList<String>(Arrays.asList("c", "b")));
		queries.add(new ArrayList<String>(Arrays.asList("bc", "cd")));
		queries.add(new ArrayList<String>(Arrays.asList("cd", "bc")));
		System.out.println(Arrays.toString(calcEquation(equations, new double[] { 1.5, 2.5, 5.0 }, queries)));

		equations = new ArrayList<List<String>>();
		equations.add(new ArrayList<String>(Arrays.asList("a", "b")));
		queries = new ArrayList<List<String>>();
		queries.add(new ArrayList<String>(Arrays.asList("a", "b")));
		queries.add(new ArrayList<String>(Arrays.asList("b", "a")));
		queries.add(new ArrayList<String>(Arrays.asList("a", "c")));
		queries.add(new ArrayList<String>(Arrays.asList("x", "y")));
		System.out.println(Arrays.toString(calcEquation(equations, new double[] { 0.5 }, queries)));
	}

	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		HashMap<String, HashMap<String, Double>> adjList = new HashMap<String, HashMap<String, Double>>();

		for (int i = 0; i < values.length; i++) {
			List<String> lst = equations.get(i);
			double val = values[i];

			String src = lst.get(0);
			String dst = lst.get(1);

			if (!adjList.containsKey(src)) {
				adjList.put(src, new HashMap<String, Double>());
			}
			adjList.get(src).put(dst, val);

			if (!adjList.containsKey(dst)) {
				adjList.put(dst, new HashMap<String, Double>());
			}

			adjList.get(dst).put(src, 1 / val);
		}

		double[] out = new double[queries.size()];

		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			out[i] = dfs(query.get(0), query.get(1), adjList, new HashSet<String>());
		}
		return out;
	}

	public static double dfs(String src, String dst, HashMap<String, HashMap<String, Double>> adjList,
			HashSet<String> visited) {
		if (visited.contains(src) || !adjList.containsKey(src) || !adjList.containsKey(dst))
			return -1.0;

		if (adjList.get(src).containsKey(dst)) {
			return adjList.get(src).get(dst);
		}

		visited.add(src);
		HashMap<String, Double> map = adjList.get(src);
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			double val = dfs(entry.getKey(), dst, adjList, visited);
			if (val != -1.0) {
				return val * entry.getValue();
			}
		}
		visited.remove(src);
		return -1.0;
	}
}
