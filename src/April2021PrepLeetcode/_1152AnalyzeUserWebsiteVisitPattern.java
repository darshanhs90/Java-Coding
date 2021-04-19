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
		HashMap<String, TreeMap<Integer, String>> webMap = new HashMap<String, TreeMap<Integer, String>>();
		for (int i = 0; i < website.length; i++) {
			String currUsername = username[i];
			int currTimestamp = timestamp[i];
			String currWebsite = website[i];

			if (!webMap.containsKey(currUsername)) {
				webMap.put(currUsername, new TreeMap<Integer, String>());
			}

			webMap.get(currUsername).put(currTimestamp, currWebsite);
		}

		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (Map.Entry<String, TreeMap<Integer, String>> entry : webMap.entrySet()) {
			if (entry.getValue().size() < 3)
				continue;
			populateCount(entry.getValue(), countMap);
		}

		int count = 0;
		String mostVisitedString = "";
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > count) {
				count = entry.getValue();
				mostVisitedString = entry.getKey();
			} else if (entry.getValue() == count) {
				if (mostVisitedString.compareTo(entry.getKey()) > 0) {
					mostVisitedString = entry.getKey();
				}
			}
		}

		return new ArrayList<String>(Arrays.asList(mostVisitedString.split("/")));
	}

	public static void populateCount(TreeMap<Integer, String> map, HashMap<String, Integer> countMap) {
		HashSet<String> visited = new HashSet<String>();
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				for (int k = j + 1; k < list.size(); k++) {
					String str1 = map.get(list.get(i));
					String str2 = map.get(list.get(j));
					String str3 = map.get(list.get(k));

					String concat = str1 + "/" + str2 + "/" + str3;
					if (!visited.contains(concat)) {
						visited.add(concat);
						countMap.compute(concat, (key, v) -> v == null ? 1 : v + 1);
					}
				}
			}
		}
	}

}
