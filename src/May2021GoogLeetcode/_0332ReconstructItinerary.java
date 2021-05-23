package May2021GoogLeetcode;

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
		if (tickets == null || tickets.size() == 0)
			return new ArrayList<String>();

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

		List<List<String>> out = new ArrayList<List<String>>();
		dfs("JFK", tickets.size() + 1, map, out, new ArrayList<String>(Arrays.asList("JFK")));
		return out.get(0);
	}

	public static void dfs(String src, int noOfTickets, HashMap<String, List<String>> map, List<List<String>> out,
			List<String> list) {
		if (list.size() == noOfTickets) {
			out.add(new ArrayList<String>(list));
			return;
		}

		if (!map.containsKey(src))
			return;

		List<String> tempList = map.get(src);

		for (int i = 0; i < tempList.size(); i++) {
			String newSrc = tempList.remove(i);
			list.add(newSrc);
			dfs(newSrc, noOfTickets, map, out, list);
			list.remove(list.size() - 1);
			tempList.add(i, newSrc);
		}
	}

}
