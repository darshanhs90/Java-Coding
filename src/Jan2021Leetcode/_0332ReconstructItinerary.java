package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
		int noOfTickets = tickets.size();
		for (List<String> list : tickets) {
			String source = list.get(0);
			String destination = list.get(1);

			if (adjList.containsKey(source)) {
				adjList.get(source).add(destination);
			} else {
				List<String> tempList = new ArrayList<String>();
				tempList.add(destination);
				adjList.put(source, tempList);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();

		dfs("JFK", adjList, noOfTickets, new ArrayList<String>(Arrays.asList("JFK")), output);

		List<String> outputVal = null;
		String outputStr = null;
		for (List<String> lst : output) {
			String str = String.join(",", lst);
			if (outputStr == null) {
				outputStr = str;
				outputVal = lst;
			} else {
				if (outputStr.compareTo(str) > 0) {
					outputStr = str;
					outputVal = lst;
				}
			}
		}

		return outputVal;
	}

	public static void dfs(String source, HashMap<String, List<String>> adjList, int noOfTickets, List<String> list,
			List<List<String>> output) {
		if (noOfTickets == 0) {
			output.add(new ArrayList<String>(list));
			return;
		}

		if (adjList.containsKey(source)) {
			List<String> lst = new ArrayList<String>(adjList.get(source));
			for (String str : lst) {
				adjList.get(source).remove(str);
				list.add(str);
				dfs(str, adjList, noOfTickets - 1, list, output);
				list.remove(list.size() - 1);
				adjList.get(source).add(str);
			}
		}
	}

}
