package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
		for (List<String> ticket : tickets) {
			String source = ticket.get(0);
			String dest = ticket.get(1);
			if (!adjList.containsKey(source)) {
				adjList.put(source, new ArrayList<String>());
			}
			adjList.get(source).add(dest);
		}

		List<List<String>> output = new ArrayList<List<String>>();
		dfs("JFK", adjList, tickets.size(), new ArrayList<String>(Arrays.asList("JFK")), output);
		Collections.sort(output, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				// TODO Auto-generated method stub
				String str1 = String.join(",", o1);
				String str2 = String.join(",", o2);
				return str1.compareTo(str2);
			}
		});

		return output.get(0);
	}

	public static void dfs(String source, HashMap<String, List<String>> adjList, int noOfTickets, List<String> tempList,
			List<List<String>> output) {
		if (tempList.size() == noOfTickets + 1) {
			output.add(new ArrayList<String>(tempList));
			return;
		}
		if (adjList.containsKey(source)) {
			List<String> list = adjList.get(source);
			for (int i = 0; i < list.size(); i++) {
				String newSrc = list.get(i);
				tempList.add(newSrc);
				list.remove(i);
				dfs(newSrc, adjList, noOfTickets, tempList, output);
				list.add(i, newSrc);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
