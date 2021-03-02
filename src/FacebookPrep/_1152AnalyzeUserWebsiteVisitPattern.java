package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _1152AnalyzeUserWebsiteVisitPattern {
	public static void main(String[] args) {
		System.out.println(mostVisitedPattern(
				new String[] { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" },
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				new String[] { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" }));
	}

	public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		HashMap<String, TreeMap<Integer, String>> map = new HashMap<String, TreeMap<Integer, String>>();
		for (int i = 0; i < website.length; i++) {
			if (!map.containsKey(username[i])) {
				map.put(username[i], new TreeMap<Integer, String>());
			}
			map.get(username[i]).put(timestamp[i], website[i]);
		}

		HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
		for (Map.Entry<String, TreeMap<Integer, String>> entry : map.entrySet()) {
			if (entry.getValue().size() < 3)
				continue;
			populateSet(entry.getValue(), stringMap);
		}

		String str = "";
		int max = 0;
		for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				str = entry.getKey();
			} else if (entry.getValue() == max) {
				if (entry.getKey().compareTo(str) < 0) {
					str = entry.getKey();
				}
			}
		}

		List<String> out = new ArrayList<String>(Arrays.asList(str.split("/")));
		return out;
	}

	public static void populateSet(TreeMap<Integer, String> map, HashMap<String, Integer> stringMap) {
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < list.size() - 2; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				for (int j2 = j + 1; j2 < list.size(); j2++) {
					String str = map.get(list.get(i)) + "/" + map.get(list.get(j)) + "/" + map.get(list.get(j2));
					if (!visited.contains(str)) {
						stringMap.compute(str, (k, v) -> v == null ? 1 : v + 1);
						visited.add(str);
					}
				}
			}
		}
	}

}
