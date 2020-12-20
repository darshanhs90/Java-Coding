package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _009ReconstuctItinerary {

	public static void main(String[] args) {

		System.out.println(findItinerary(new ArrayList<List<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("MUC", "LHR")), new ArrayList<String>(Arrays.asList("JFK", "MUC")),
				new ArrayList<String>(Arrays.asList("SFO", "SJC")),
				new ArrayList<String>(Arrays.asList("LHR", "SFO"))))));

		System.out.println(findItinerary(new ArrayList<List<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("JFK", "SFO")), new ArrayList<String>(Arrays.asList("JFK", "ATL")),
				new ArrayList<String>(Arrays.asList("SFO", "ATL")), new ArrayList<String>(Arrays.asList("ATL", "JFK")),
				new ArrayList<String>(Arrays.asList("ATL", "SFO"))))));

		System.out.println(findItinerary(new ArrayList<List<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("JFK", "KUL")), new ArrayList<String>(Arrays.asList("JFK", "NRT")),
				new ArrayList<String>(Arrays.asList("NRT", "JFK"))))));

	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (List<String> pair : tickets) {
			String source = pair.get(0);
			String destination = pair.get(1);
			if (map.containsKey(source)) {
				map.get(source).add(destination);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(destination);
				map.put(source, list);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		list.add("JFK");
		dfs("JFK", 1, map, list, output, tickets.size() + 1, new HashSet<List<String>>());
		Collections.sort(output, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				for (int i = 0; i < o1.size(); i++) {
					if (o1.get(i).compareTo(o2.get(i)) != 0)
						return o1.get(i).compareTo(o2.get(i));
				}

				return 0;
			}
		});
		return output.get(0);
	}

	public static void dfs(String startPoint, int currcount, HashMap<String, List<String>> map, List<String> list,
			List<List<String>> output, int maxCount, Set<List<String>> set) {
		if (list.size() == maxCount) {
			if (!set.contains(list)) {
				output.add(new ArrayList<String>(list));
				set.add(list);
			}
			return;
		}

		List<String> neighbors = map.get(startPoint);
		if (neighbors != null)
			for (int i = 0; i < neighbors.size(); i++) {
				String nextDestination = neighbors.get(i);
				map.get(startPoint).remove(String.valueOf(nextDestination));
				list.add(nextDestination);
				dfs(nextDestination, currcount + 1, map, list, output, maxCount, set);
				list.remove(list.size() - 1);
				map.get(startPoint).add(i, String.valueOf(nextDestination));
			}
	}

}
