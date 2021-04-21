package April2021PrepLeetcode;

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
			String currUsername = username[i];
			int currTimestamp = timestamp[i];
			String currWebsite = website[i];

			if (!map.containsKey(currUsername)) {
				map.put(currUsername, new TreeMap<Integer, String>());
			}

			map.get(currUsername).put(currTimestamp, currWebsite);
		}
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (Map.Entry<String, TreeMap<Integer, String>> entry : map.entrySet()) {
			if (entry.getValue().size() < 3)
				continue;
			populateMap(entry.getValue(), countMap);
		}

		int count = 0;
		String maxString = "";
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > count) {
				count = entry.getValue();
				maxString = entry.getKey();
			} else if (entry.getValue() == count) {
				if (entry.getKey().compareTo(maxString) < 0) {
					maxString = entry.getKey();
				}
			}
		}
		return new ArrayList<String>(Arrays.asList(maxString.split("/")));
	}

	public static void populateMap(TreeMap<Integer, String> map, HashMap<String, Integer> countMap) {
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		HashSet<String> visited = new HashSet<String>();

		for (int i = 0; i < list.size() - 2; i++) {
			for (int j = i + 1; j < list.size() - 1; j++) {
				for (int k = j + 1; k < list.size(); k++) {

					String str1 = map.get(list.get(i));
					String str2 = map.get(list.get(j));
					String str3 = map.get(list.get(k));

					String str = str1 + "/" + str2 + "/" + str3;
					if (!visited.contains(str)) {
						visited.add(str);
						countMap.compute(str, (key, v) -> v == null ? 1 : v + 1);
					}
				}
			}
		}
	}
}
