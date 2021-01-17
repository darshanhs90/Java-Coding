package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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

		HashMap<String, List<String>> emailToEmailNeighborsMap = new HashMap<String, List<String>>();
		HashMap<String, String> emailToUserMap = new HashMap<String, String>();

		for (List<String> account : accounts) {
			String username = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				emailToUserMap.put(account.get(i), username);

				if (emailToEmailNeighborsMap.containsKey(account.get(1))) {
					emailToEmailNeighborsMap.get(account.get(1)).add(account.get(i));
				} else {
					emailToEmailNeighborsMap.put(account.get(1), new ArrayList<String>());
					emailToEmailNeighborsMap.get(account.get(1)).add(account.get(i));
				}

				if (emailToEmailNeighborsMap.containsKey(account.get(i))) {
					emailToEmailNeighborsMap.get(account.get(i)).add(account.get(1));

				} else {
					emailToEmailNeighborsMap.put(account.get(i), new ArrayList<String>());
					emailToEmailNeighborsMap.get(account.get(i)).add(account.get(1));
				}
			}
		}

		HashSet<String> visited = new HashSet<String>();
		List<List<String>> output = new ArrayList<List<String>>();
		for (String str : emailToEmailNeighborsMap.keySet()) {
			if (!visited.contains(str)) {
				List<String> list = new ArrayList<String>();
				dfs(emailToEmailNeighborsMap, str, list, visited);

				Collections.sort(list);
				list.add(0, emailToUserMap.get(str));
				output.add(list);
			}
		}

		return output;

	}

	public static void dfs(HashMap<String, List<String>> emailToEmailNeighborsMap, String sourceEmail,
			List<String> list, HashSet<String> visited) {
		if (visited.contains(sourceEmail)) {
			return;
		}

		visited.add(sourceEmail);
		list.add(sourceEmail);

		List<String> neighbors = emailToEmailNeighborsMap.get(sourceEmail);
		for (String str : neighbors) {
			dfs(emailToEmailNeighborsMap, str, list, visited);
		}
	}

}
