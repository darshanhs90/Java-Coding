package Dec2020Leetcode;

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
		HashMap<String, HashMap<String, Double>> equationGraph = new HashMap<String, HashMap<String, Double>>();
		for (int i = 0; i < equations.size(); i++) {
			String source = equations.get(i).get(0);
			String destination = equations.get(i).get(1);
			if (equationGraph.containsKey(source)) {
				equationGraph.get(source).put(destination, values[i]);
			} else {
				HashMap<String, Double> tempMap = new HashMap<String, Double>();
				tempMap.put(destination, values[i]);
				equationGraph.put(source, tempMap);
			}

			if (equationGraph.containsKey(destination)) {
				equationGraph.get(destination).put(source, 1 / values[i]);
			} else {
				HashMap<String, Double> tempMap = new HashMap<String, Double>();
				tempMap.put(source, 1 / values[i]);
				equationGraph.put(destination, tempMap);
			}
		}

		double output[] = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			String source = queries.get(i).get(0);
			String destination = queries.get(i).get(1);
			if (!equationGraph.containsKey(source) || !equationGraph.containsKey(destination))
				output[i] = -1.0;
			else {
				double val = dfs(source, destination, equationGraph, new HashSet<String>());
				output[i] = val == Double.MAX_VALUE ? -1.0 : val;
			}
		}
		return output;
	}

	public static double dfs(String source, String destination, HashMap<String, HashMap<String, Double>> equationGraph,
			HashSet<String> visited) {

		if (!equationGraph.containsKey(source) || visited.contains(source))
			return Double.MAX_VALUE;

		if (equationGraph.get(source).containsKey(destination))
			return equationGraph.get(source).get(destination);

		visited.add(source);
		HashMap<String, Double> sourceMap = equationGraph.get(source);
		for (Map.Entry<String, Double> entry : sourceMap.entrySet()) {
			double val = dfs(entry.getKey(), destination, equationGraph, visited);
			if (val != Double.MAX_VALUE) {
				return val * entry.getValue();
			}
		}

		return Double.MAX_VALUE;
	}
}
