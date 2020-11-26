package Nov2020Leetcode;

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
		int noOfTickets = 0;
		HashMap<String, List<String>> adjList = new HashMap<String, List<String>>();
		for (int i = 0; i < tickets.size(); i++) {
			String startPoint = tickets.get(i).get(0);
			String endPoint = tickets.get(i).get(1);
			noOfTickets++;
			if (adjList.containsKey(startPoint)) {
				adjList.get(startPoint).add(endPoint);
			} else {
				adjList.put(startPoint, new ArrayList<String>(Arrays.asList(endPoint)));
			}
		}
		for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
			Collections.sort(entry.getValue());
		}

		List<List<String>> output = new ArrayList<List<String>>();
		dfs("JFK", noOfTickets, new ArrayList<String>(Arrays.asList("JFK")), output, adjList);
		return output.get(0);
	}

	public static void dfs(String startingPoint, int noOfTickets, List<String> list, List<List<String>> output,
			HashMap<String, List<String>> adjList) {
		if (noOfTickets == 0) {
			output.add(new ArrayList<String>(list));
			return;
		}

		if (!adjList.containsKey(startingPoint) || adjList.get(startingPoint).size() == 0) {
			return;
		}
		List<String> possibleDestinations = adjList.get(startingPoint);
		for (int i = 0; i < possibleDestinations.size(); i++) {
			String newStartingPoint = possibleDestinations.get(i);
			list.add(newStartingPoint);
			adjList.get(startingPoint).remove(i);
			dfs(newStartingPoint, noOfTickets - 1, list, output, adjList);
			adjList.get(startingPoint).add(i, newStartingPoint);
			list.remove(list.size() - 1);
		}
	}

}
