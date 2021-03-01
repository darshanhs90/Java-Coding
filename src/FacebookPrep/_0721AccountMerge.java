package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
		HashMap<String, String> emailToNameMap = new HashMap<String, String>();
		HashMap<String, HashSet<String>> emailToEmailMap = new HashMap<String, HashSet<String>>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String baseEmail = account.get(1);
				String currEmail = account.get(i);

				emailToNameMap.put(currEmail, name);
				if (emailToEmailMap.containsKey(currEmail)) {
					emailToEmailMap.get(currEmail).add(baseEmail);
				} else {
					HashSet<String> set = new HashSet<String>();
					set.add(baseEmail);
					emailToEmailMap.put(currEmail, set);
				}

				if (emailToEmailMap.containsKey(baseEmail)) {
					emailToEmailMap.get(baseEmail).add(currEmail);
				} else {
					HashSet<String> set = new HashSet<String>();
					set.add(currEmail);
					emailToEmailMap.put(baseEmail, set);
				}
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<String> visited = new HashSet<String>();

		for (Map.Entry<String, HashSet<String>> entry : emailToEmailMap.entrySet()) {
			String source = entry.getKey();
			if (!visited.contains(source)) {
				List<String> list = new ArrayList<String>();
				dfs(source, emailToEmailMap, visited, list);
				Collections.sort(list);
				list.add(0, emailToNameMap.get(source));
				output.add(list);
			}
		}
		return output;
	}

	public static void dfs(String source, HashMap<String, HashSet<String>> emailToEmailMap, HashSet<String> visited,
			List<String> list) {
		if (visited.contains(source))
			return;
		visited.add(source);
		list.add(source);

		Iterator<String> iter = emailToEmailMap.get(source).iterator();
		while (iter.hasNext()) {
			dfs(iter.next(), emailToEmailMap, visited, list);
		}
	}

}
