package Jan2021Leetcode;

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
		HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
		for (int i = 0; i < values.length; i++) {
			List<String> equation = equations.get(i);
			double value = values[i];
			String source = equation.get(0);
			String destination = equation.get(1);

			if (map.containsKey(source)) {
				map.get(source).put(destination, value);
			} else {
				HashMap<String, Double> tempMap = new HashMap<String, Double>();
				tempMap.put(destination, value);
				map.put(source, tempMap);
			}

			if (map.containsKey(destination)) {
				map.get(destination).put(source, 1 / value);
			} else {
				HashMap<String, Double> tempMap = new HashMap<String, Double>();
				tempMap.put(source, 1 / value);
				map.put(destination, tempMap);
			}
		}

		double[] output = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			String source = queries.get(i).get(0);
			String destination = queries.get(i).get(1);
			if (!map.containsKey(source) || !map.containsKey(destination))
				output[i] = -1.0;
			else {
				canReach = false;
				HashSet<String> visited = new HashSet<String>();
				visited.add(source);
				output[i] = dfs(source, destination, map, visited);
			}
		}
		return output;
	}

	static boolean canReach = false;

	public static double dfs(String source, String destination, HashMap<String, HashMap<String, Double>> map,
			HashSet<String> visited) {

		if (source.equals(destination)) {
			canReach = true;
			return 1;
		}

		if (map.get(source).containsKey(destination)) {
			canReach = true;
			return map.get(source).get(destination);
		}

		HashMap<String, Double> tempMap = map.get(source);
		for (Map.Entry<String, Double> entry : tempMap.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				visited.add(entry.getKey());
				double val = dfs(entry.getKey(), destination, map, visited);
				if (canReach) {
					return val * entry.getValue();
				}
				visited.remove(entry.getKey());
			}
		}
		return -1;
	}
}
