package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _010EvaluateDivision {

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

		for (int i = 0; i < equations.size(); i++) {
			double currVal = values[i];
			String start = equations.get(i).get(0);
			String end = equations.get(i).get(1);
			if (map.containsKey(start)) {
				HashMap<String, Double> destMap = map.get(start);
				destMap.put(end, currVal);
				map.put(start, destMap);
			} else {
				HashMap<String, Double> destMap = new HashMap<String, Double>();
				destMap.put(end, currVal);
				map.put(start, destMap);
			}

			if (map.containsKey(end)) {
				HashMap<String, Double> destMap = map.get(end);
				destMap.put(start, 1 / currVal);
				map.put(end, destMap);
			} else {
				HashMap<String, Double> destMap = new HashMap<String, Double>();
				destMap.put(start, 1 / currVal);
				map.put(end, destMap);
			}
		}
		System.out.println(map);
		double[] out = new double[queries.size()];
		int index = 0;
		for (List<String> query : queries) {
			String start = query.get(0);
			String end = query.get(1);
			out[index] = dfs(start, end, map, new HashSet<String>());
			index++;
		}
		return out;
	}

	public static double dfs(String start, String end, HashMap<String, HashMap<String, Double>> map,
			HashSet<String> visited) {
		if (!map.containsKey(start))
			return -1.0;

		if (map.get(start).containsKey(end))
			return map.get(start).get(end);

		visited.add(start);

		HashMap<String, Double> newMap = map.get(start);

		for (Map.Entry<String, Double> entry : newMap.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				double val = dfs(entry.getKey(), end, map, visited);
				if (val != -1.0) {
					return entry.getValue() * val;
				}
			}
		}
		return -1.0;
	}

}
