package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
		HashMap<String, List<String>> adjList = new HashMap<String, List<String>>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String dst = ticket.get(1);

			if (!adjList.containsKey(src)) {
				adjList.put(src, new ArrayList<String>());
			}
			adjList.get(src).add(dst);
		}

		for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
			Collections.sort(entry.getValue());
		}

		List<List<String>> output = new ArrayList<List<String>>();
		dfs("JFK", adjList, tickets.size() + 1, new ArrayList<String>(Arrays.asList("JFK")), output);
		return output.get(0);
	}

	public static void dfs(String src, HashMap<String, List<String>> adjList, int noOfTickets, List<String> temp,
			List<List<String>> output) {
		if (temp.size() == noOfTickets) {
			output.add(new ArrayList<String>(temp));
			return;
		}

		if (!adjList.containsKey(src))
			return;
		List<String> neighbors = adjList.get(src);
		for (int i = 0; i < neighbors.size(); i++) {
			String newSrc = neighbors.remove(i);
			temp.add(newSrc);
			dfs(newSrc, adjList, noOfTickets, temp, output);
			temp.remove(temp.size() - 1);
			neighbors.add(i, newSrc);
		}
	}

}
