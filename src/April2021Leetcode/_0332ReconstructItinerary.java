package April2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String dst = ticket.get(1);
			if (!map.containsKey(src)) {
				map.put(src, new ArrayList<String>());
				map.get(src).add(dst);
			} else {
				map.get(src).add(dst);
				Collections.sort(map.get(src));
			}
		}
		List<List<String>> output = new ArrayList<List<String>>();
		dfs("JFK", tickets.size() + 1, map, new ArrayList<String>(Arrays.asList("JFK")), output);
		return output.get(0);
	}

	public static void dfs(String src, int noOfTickets, HashMap<String, List<String>> map, List<String> list,
			List<List<String>> output) {
		if (list.size() == noOfTickets) {
			output.add(new ArrayList<String>(list));
			return;
		}

		if (map.containsKey(src)) {
			List<String> tempList = map.get(src);
			for (int i = 0; i < tempList.size(); i++) {
				String newSrc = tempList.remove(i);
				list.add(newSrc);
				dfs(newSrc, noOfTickets, map, list, output);
				list.remove(list.size() - 1);
				tempList.add(i, newSrc);
			}
		}
	}
}
