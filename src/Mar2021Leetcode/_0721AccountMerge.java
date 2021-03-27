package Mar2021Leetcode;

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
		HashMap<String, String> emailToUserNameMap = new HashMap<String, String>();

		for (List<String> list : accounts) {
			String userName = list.get(0);
			String baseEmail = list.get(1);
			for (int i = 1; i < list.size(); i++) {
				String currEmail = list.get(i);
				if (!emailToEmailMap.containsKey(currEmail)) {
					emailToEmailMap.put(currEmail, new ArrayList<String>());
				}
				emailToEmailMap.get(currEmail).add(baseEmail);

				if (!emailToEmailMap.containsKey(baseEmail)) {
					emailToEmailMap.put(baseEmail, new ArrayList<String>());
				}

				emailToEmailMap.get(baseEmail).add(currEmail);
				emailToUserNameMap.put(currEmail, userName);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visitedEmails = new HashSet<String>();

		for (Map.Entry<String, List<String>> entry : emailToEmailMap.entrySet()) {

			if (!visitedEmails.contains(entry.getKey())) {
				List<String> list = new ArrayList<String>();
				dfs(entry.getKey(), emailToEmailMap, visitedEmails, list);
				Collections.sort(list);
				list.add(0, emailToUserNameMap.get(entry.getKey()));
				output.add(list);
			}
		}
		return output;
	}

	public static void dfs(String email, HashMap<String, List<String>> emailToEmailMap, HashSet<String> visited,
			List<String> list) {
		if (visited.contains(email))
			return;

		visited.add(email);
		list.add(email);

		List<String> emails = emailToEmailMap.get(email);
		for (String newEmail : emails) {
			dfs(newEmail, emailToEmailMap, visited, list);
		}
	}

}
