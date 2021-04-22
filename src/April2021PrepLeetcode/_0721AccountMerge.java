package April2021PrepLeetcode;

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
		if (accounts == null || accounts.size() < 2)
			return accounts;
		HashMap<String, List<String>> eeMap = new HashMap<String, List<String>>();
		HashMap<String, String> euMap = new HashMap<String, String>();

		for (List<String> list : accounts) {
			String userName = list.get(0);
			String baseEmail = list.get(1);
			for (int i = 1; i < list.size(); i++) {
				String currEmail = list.get(i);
				if (!eeMap.containsKey(baseEmail)) {
					eeMap.put(baseEmail, new ArrayList<String>());
				}

				if (!eeMap.containsKey(currEmail)) {
					eeMap.put(currEmail, new ArrayList<String>());
				}

				eeMap.get(baseEmail).add(currEmail);
				eeMap.get(currEmail).add(baseEmail);
				euMap.put(currEmail, userName);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visited = new HashSet<String>();
		for (Map.Entry<String, List<String>> entry : eeMap.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				List<String> list = new ArrayList<String>();
				dfs(entry.getKey(), eeMap, list, visited);

				Collections.sort(list);
				list.add(0, euMap.get(entry.getKey()));
				output.add(list);
			}
		}
		return output;
	}

	public static void dfs(String currEmail, HashMap<String, List<String>> eeMap, List<String> output,
			HashSet<String> visited) {
		if (visited.contains(currEmail))
			return;
		visited.add(currEmail);
		output.add(currEmail);
		if (!eeMap.containsKey(currEmail))
			return;
		List<String> list = eeMap.get(currEmail);
		for (String str : list) {
			dfs(str, eeMap, output, visited);
		}
	}

}
