package April2021PrepLeetcode;

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
			String src = equation.get(0);
			String dst = equation.get(1);

			double val = values[i];

			if (!map.containsKey(src)) {
				map.put(src, new HashMap<String, Double>());
			}

			if (!map.containsKey(dst)) {
				map.put(dst, new HashMap<String, Double>());
			}

			map.get(src).put(dst, val);
			map.get(dst).put(src, 1 / val);
		}

		double[] output = new double[queries.size()];
		for (int i = 0; i < output.length; i++) {
			List<String> query = queries.get(i);
			String src = query.get(0);
			String dst = query.get(1);
			output[i] = calcValue(src, dst, map, new HashSet<String>());
		}
		return output;
	}

	public static double calcValue(String src, String dst, HashMap<String, HashMap<String, Double>> map,
			HashSet<String> visited) {
		if (!map.containsKey(src))
			return -1.0;

		if (map.get(src).containsKey(dst))
			return map.get(src).get(dst);
		visited.add(src);
		HashMap<String, Double> map1 = map.get(src);
		for (Map.Entry<String, Double> entry : map1.entrySet()) {
			String newSrc = entry.getKey();
			if (!visited.contains(newSrc)) {
				double currVal = calcValue(newSrc, dst, map, visited);
				if (currVal != -1.0) {
					return currVal * entry.getValue();
				}
			}
		}
		visited.remove(src);
		return -1.0;
	}
}
