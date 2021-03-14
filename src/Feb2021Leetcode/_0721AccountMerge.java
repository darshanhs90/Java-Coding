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
		if (accounts == null || accounts.size() < 2)
			return accounts;
		HashMap<String, List<String>> emailToEmailMap = new HashMap<String, List<String>>();
		HashMap<String, String> emailToNameMap = new HashMap<String, String>();

		for (List<String> account : accounts) {
			String username = account.get(0);
			String baseEmail = account.get(1);
			for (int i = 1; i < account.size(); i++) {
				String currEmail = account.get(i);

				if (!emailToEmailMap.containsKey(baseEmail)) {
					emailToEmailMap.put(baseEmail, new ArrayList<String>());
				}
				emailToEmailMap.get(baseEmail).add(currEmail);
				if (!emailToEmailMap.containsKey(currEmail)) {
					emailToEmailMap.put(currEmail, new ArrayList<String>());
				}
				emailToEmailMap.get(currEmail).add(baseEmail);

				emailToNameMap.put(currEmail, username);
			}
		}
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visitedEmails = new HashSet<String>();
		for (Map.Entry<String, List<String>> entry : emailToEmailMap.entrySet()) {
			if (!visitedEmails.contains(entry.getKey())) {
				List<String> list = new ArrayList<String>();
				dfs(entry.getKey(), emailToEmailMap, list, visitedEmails);
				Collections.sort(list);
				list.add(0, emailToNameMap.get(entry.getKey()));
				output.add(list);
			}
		}
		return output;
	}

	public static void dfs(String source, HashMap<String, List<String>> emailToEmailMap, List<String> list,
			HashSet<String> visitedEmails) {
		if (visitedEmails.contains(source))
			return;
		visitedEmails.add(source);
		list.add(source);

		if (emailToEmailMap.containsKey(source)) {

			List<String> adjList = emailToEmailMap.get(source);
			for (String str : adjList) {
				dfs(str, emailToEmailMap, list, visitedEmails);
			}
		}
	}

}
