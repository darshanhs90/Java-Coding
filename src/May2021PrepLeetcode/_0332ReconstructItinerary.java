package May2021PrepLeetcode;

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
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String dst = ticket.get(1);

			if (!map.containsKey(src)) {
				map.put(src, new ArrayList<String>());
			}
			map.get(src).add(dst);
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		List<List<String>> output = new ArrayList<List<String>>();
		dfs("JFK", tickets.size() + 1, map, new ArrayList<String>(Arrays.asList("JFK")), output);
		return output.get(0);
	}

	public static void dfs(String src, int noOfTickets, HashMap<String, List<String>> map, List<String> tempList,
			List<List<String>> output) {
		if (tempList.size() == noOfTickets) {
			output.add(new ArrayList<String>(tempList));
			return;
		}

		if (!map.containsKey(src))
			return;
		List<String> list = map.get(src);
		for (int i = 0; i < list.size(); i++) {
			String newSrc = list.remove(i);
			tempList.add(newSrc);
			dfs(newSrc, noOfTickets, map, tempList, output);
			tempList.remove(tempList.size() - 1);
			list.add(i, newSrc);
		}
	}

}
