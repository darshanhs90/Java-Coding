package May2021Leetcode;

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
		HashMap<String, List<String>> emailToEmailMap = new HashMap<String, List<String>>();
		HashMap<String, String> emailToNameMap = new HashMap<String, String>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			String baseEmail = account.get(1);
			for (int i = 1; i < account.size(); i++) {
				String currEmail = account.get(i);
				if (!emailToEmailMap.containsKey(baseEmail)) {
					emailToEmailMap.put(baseEmail, new ArrayList<String>());
				}

				if (!emailToEmailMap.containsKey(currEmail)) {
					emailToEmailMap.put(currEmail, new ArrayList<String>());
				}

				emailToNameMap.put(currEmail, name);
				emailToEmailMap.get(baseEmail).add(currEmail);
				emailToEmailMap.get(currEmail).add(baseEmail);
			}
		}
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visited = new HashSet<String>();
		for (Map.Entry<String, List<String>> entry : emailToEmailMap.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				List<String> list = new ArrayList<String>();
				dfs(entry.getKey(), emailToEmailMap, list, visited);

				Collections.sort(list);
				list.add(0, emailToNameMap.get(entry.getKey()));
				output.add(list);
			}
		}
		return output;
	}

	public static void dfs(String src, HashMap<String, List<String>> emailToEmailMap, List<String> list,
			HashSet<String> visited) {
		if (visited.contains(src))
			return;
		list.add(src);
		visited.add(src);

		if (!emailToEmailMap.containsKey(src))
			return;
		List<String> emailList = emailToEmailMap.get(src);
		for (String str : emailList) {
			dfs(str, emailToEmailMap, list, visited);
		}
	}

}
