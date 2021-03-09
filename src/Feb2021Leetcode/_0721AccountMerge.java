package Feb2021Leetcode;

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
		if (accounts == null || accounts.size() == 0)
			return accounts;

		HashMap<String, String> emailToNameMap = new HashMap<String, String>();
		HashMap<String, List<String>> emailToEmailMap = new HashMap<String, List<String>>();

		for (int i = 0; i < accounts.size(); i++) {

			List<String> account = accounts.get(i);
			String userName = account.get(0);
			String baseEmail = account.get(1);
			for (int j = 1; j < account.size(); j++) {
				String currEmail = account.get(j);
				emailToNameMap.put(currEmail, userName);

				if (emailToEmailMap.containsKey(currEmail)) {
					emailToEmailMap.get(currEmail).add(baseEmail);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(baseEmail);
					emailToEmailMap.put(currEmail, list);
				}

				if (emailToEmailMap.containsKey(baseEmail)) {
					emailToEmailMap.get(baseEmail).add(currEmail);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(currEmail);
					emailToEmailMap.put(baseEmail, list);
				}
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visited = new HashSet<String>();
		for (Map.Entry<String, List<String>> entry : emailToEmailMap.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				List<String> lst = new ArrayList<String>();
				dfs(entry.getKey(), emailToEmailMap, lst, visited);

				Collections.sort(lst);
				lst.add(0, emailToNameMap.get(entry.getKey()));
				output.add(lst);
			}

		}
		return output;
	}

	public static void dfs(String currEmail, HashMap<String, List<String>> emailToEmailMap, List<String> list,
			HashSet<String> visited) {
		if (visited.contains(currEmail))
			return;

		list.add(currEmail);
		visited.add(currEmail);
		List<String> lst = emailToEmailMap.get(currEmail);
		for (int i = 0; i < lst.size(); i++) {
			dfs(lst.get(i), emailToEmailMap, list, visited);
		}
	}

}
