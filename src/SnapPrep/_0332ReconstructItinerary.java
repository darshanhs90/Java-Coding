package SnapPrep;

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

		int noOfTickets = tickets.size() + 1;
		List<List<String>> output = new ArrayList<List<String>>();
		dfs("JFK", adjList, noOfTickets, new ArrayList<String>(Arrays.asList("JFK")), output);
		return output.get(0);
	}

	public static void dfs(String src, HashMap<String, List<String>> adjList, int noOfTickets, List<String> list,
			List<List<String>> output) {
		if (list.size() == noOfTickets) {
			output.add(new ArrayList<String>(list));
			return;
		}

		if (!adjList.containsKey(src))
			return;
		List<String> tempList = adjList.get(src);
		for (int i = 0; i < tempList.size(); i++) {
			String newSrc = tempList.get(i);
			list.add(newSrc);
			tempList.remove(i);
			dfs(newSrc, adjList, noOfTickets, list, output);
			tempList.add(i, newSrc);
			list.remove(list.size() - 1);
		}
	}

}
