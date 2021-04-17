package April2021Leetcode;

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
			String currUserName = username[i];
			int currTimestamp = timestamp[i];
			String currWebsite = website[i];
			if (!webMap.containsKey(currUserName)) {
				webMap.put(currUserName, new TreeMap<Integer, String>());
			}
			webMap.get(currUserName).put(currTimestamp, currWebsite);
		}

		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (Map.Entry<String, TreeMap<Integer, String>> entry : webMap.entrySet()) {
			if (entry.getValue().size() < 3)
				continue;
			populateMap(entry.getKey(), entry.getValue(), countMap);
		}

		int maxCount = 0;
		String maxString = "";
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxString = entry.getKey();
			} else if (entry.getValue() == maxCount) {
				if (maxString.compareTo(entry.getKey()) > 0) {
					maxString = entry.getKey();
				}
			}
		}

		return new ArrayList<String>(Arrays.asList(maxString.split("/")));
	}

	public static void populateMap(String username, TreeMap<Integer, String> tMap, HashMap<String, Integer> countMap) {
		List<Integer> timeStamps = new ArrayList<Integer>(tMap.keySet());
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < timeStamps.size(); i++) {
			for (int j = i + 1; j < timeStamps.size(); j++) {
				for (int k = j + 1; k < timeStamps.size(); k++) {
					String website1 = tMap.get(timeStamps.get(i));
					String website2 = tMap.get(timeStamps.get(j));
					String website3 = tMap.get(timeStamps.get(k));

					String webSiteCombo = website1 + "/" + website2 + "/" + website3;

					if (!visited.contains(webSiteCombo)) {
						countMap.compute(webSiteCombo, (key, v) -> v == null ? 1 : v + 1);
						visited.add(webSiteCombo);
					}
				}
			}
		}
	}

}
