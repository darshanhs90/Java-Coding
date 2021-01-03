package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _0332ReconstructItinerary {

	public static void main(String[] args) {
		System.out.println(findItinerary(new ArrayList<List<String>>(Arrays.asList(Arrays.asList("MUC", "LHR"),
				Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO")))));
		System.out.println(findItinerary(
				new ArrayList<List<String>>(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"),
						Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO")))));

	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		List<String> output = new ArrayList<String>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (List<String> ticket : tickets) {
			String source = ticket.get(0);
			String destination = ticket.get(1);
			if (map.containsKey(source)) {
				map.get(source).add(destination);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(destination);
				map.put(source, list);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		List<List<String>> outputs = new ArrayList<List<String>>();
		output.add("JFK");
		dfs("JFK", output, map, tickets.size(), outputs, new HashSet<List<String>>());
		return outputs.get(0);
	}

	public static void dfs(String source, List<String> output, HashMap<String, ArrayList<String>> map, int noOfTickets,
			List<List<String>> outputs, HashSet<List<String>> set) {
		if (noOfTickets == 0) {
			outputs.add(new ArrayList<String>(output));
			return;
		}

		if (!map.containsKey(source) || map.get(source).size() == 0) {
			return;
		}
		ArrayList<String> neighbors = map.get(source);
		for (int i = 0; i < neighbors.size(); i++) {
			String newSource = neighbors.get(i);
			output.add(newSource);
			map.get(source).remove(newSource);
			dfs(newSource, output, map, noOfTickets - 1, outputs, set);
			map.get(source).add(0, newSource);
			output.remove(output.size() - 1);
		}

	}

}
