package Mar2021Leetcode;

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
			String currUserName = username[i];
			String currWebsite = website[i];
			int currTimeStamp = timestamp[i];

			if (!map.containsKey(currUserName)) {
				map.put(currUserName, new TreeMap<Integer, String>());
			}

			map.get(currUserName).put(currTimeStamp, currWebsite);
		}

		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (Map.Entry<String, TreeMap<Integer, String>> entry : map.entrySet()) {
			if (entry.getValue().size() < 3)
				continue;
			populateMap(entry.getValue(), countMap);
		}
		int count = 0;
		String out = "";
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > count) {
				out = entry.getKey();
				count = entry.getValue();
			} else if (entry.getValue() == count && out.compareTo(entry.getKey()) > 0) {
				out = entry.getKey();
			}
		}
		return new ArrayList<String>(Arrays.asList(out.split("/")));
	}

	public static void populateMap(TreeMap<Integer, String> map, HashMap<String, Integer> countMap) {

		List<Integer> keys = new ArrayList<Integer>(map.keySet());
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < keys.size(); i++) {
			for (int j = i + 1; j < keys.size(); j++) {
				for (int k = j + 1; k < keys.size(); k++) {
					String str = map.get(keys.get(i)) + "/" + map.get(keys.get(j)) + "/" + map.get(keys.get(k));
					if (!visited.contains(str)) {
						countMap.compute(str, (key, v) -> v == null ? 1 : v + 1);
						visited.add(str);
					}
				}
			}
		}
	}

}
