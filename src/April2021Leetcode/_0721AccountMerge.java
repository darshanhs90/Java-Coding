package April2021Leetcode;

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
		List<List<String>> output = new ArrayList<List<String>>();
		if (accounts == null || accounts.size() == 0)
			return output;

		HashMap<String, String> emailToUserMap = new HashMap<String, String>();
		HashMap<String, List<String>> emailToEmailMap = new HashMap<String, List<String>>();

		for (List<String> account : accounts) {
			String userName = account.get(0);
			String baseEmail = account.get(1);
			for (int i = 1; i < account.size(); i++) {
				String currEmail = account.get(i);
				if (!emailToEmailMap.containsKey(baseEmail)) {
					emailToEmailMap.put(baseEmail, new ArrayList<String>());
				}

				if (!emailToEmailMap.containsKey(currEmail)) {
					emailToEmailMap.put(currEmail, new ArrayList<String>());
				}

				emailToEmailMap.get(baseEmail).add(currEmail);
				emailToEmailMap.get(currEmail).add(baseEmail);
				emailToUserMap.put(currEmail, userName);
			}
		}

		HashSet<String> visitedEmails = new HashSet<String>();
		for (Map.Entry<String, List<String>> entry : emailToEmailMap.entrySet()) {
			if (!visitedEmails.contains(entry.getKey())) {
				List<String> list = new ArrayList<String>();
				dfs(entry.getKey(), emailToEmailMap, list, visitedEmails);

				Collections.sort(list);
				list.add(0, emailToUserMap.get(entry.getKey()));
				output.add(list);
			}
		}
		return output;
	}

	public static void dfs(String srcEmail, HashMap<String, List<String>> emailToEmailMap, List<String> list,
			HashSet<String> visitedEmails) {
		if (visitedEmails.contains(srcEmail))
			return;
		visitedEmails.add(srcEmail);
		list.add(srcEmail);

		List<String> neighbors = emailToEmailMap.get(srcEmail);
		for (String email : neighbors) {
			dfs(email, emailToEmailMap, list, visitedEmails);
		}
	}

}
