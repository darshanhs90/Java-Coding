package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _0721AccountMerge {
	public static void main(String[] args) {
		System.out.println(accountsMerge(new ArrayList<List<String>>(
				Arrays.asList(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")),
						new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com")),
						new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
						new ArrayList<String>(Arrays.asList("Mary", "mary@mail.com"))))));

		System.out.println(accountsMerge(new ArrayList<List<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("a", "b", "c")), new ArrayList<String>(Arrays.asList("a1", "b1")),
				new ArrayList<String>(Arrays.asList("a", "c")), new ArrayList<String>(Arrays.asList("a", "d")),
				new ArrayList<String>(Arrays.asList("a", "d", "e"))))));

	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		HashMap<String, String> nameMap = new HashMap<String, String>();

		for (List<String> list : accounts) {
			String username = list.get(0);
			String baseEmail = list.get(1);
			for (int i = 1; i < list.size(); i++) {
				String currEmail = list.get(i);

				if (!map.containsKey(baseEmail)) {
					map.put(baseEmail, new ArrayList<String>());
				}

				if (!map.containsKey(currEmail)) {
					map.put(currEmail, new ArrayList<String>());
				}

				map.get(baseEmail).add(currEmail);
				map.get(currEmail).add(baseEmail);

				nameMap.put(baseEmail, username);
				nameMap.put(currEmail, username);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visited = new HashSet<String>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				List<String> list = new ArrayList<String>();
				dfs(entry.getKey(), map, list, visited);
				Collections.sort(list);
				list.add(0, nameMap.get(entry.getKey()));
				output.add(list);
			}
		}

		return output;
	}

	public static void dfs(String src, HashMap<String, List<String>> map, List<String> list, HashSet<String> visited) {
		if (visited.contains(src))
			return;
		list.add(src);
		visited.add(src);

		if (!map.containsKey(src))
			return;

		List<String> tempList = map.get(src);
		for (String newSrc : tempList) {
			dfs(newSrc, map, list, visited);
		}
	}

}
