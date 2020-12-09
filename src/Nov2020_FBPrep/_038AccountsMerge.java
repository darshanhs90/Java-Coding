package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class _038AccountsMerge {

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
		HashMap<String, List<String>> emailsMap = new HashMap<String, List<String>>();
		HashSet<String> visited = new HashSet<String>();

		for (List<String> account : accounts) {
			String name = account.get(0);
			for (int i = 1; i < account.size(); i++) {
				String currEmail = account.get(i);
				emailToNameMap.put(currEmail, name);
				emailsMap.computeIfAbsent(currEmail, x -> new ArrayList<String>()).add(account.get(1));
				emailsMap.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(currEmail);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();

		for (String key : emailsMap.keySet()) {
			if (visited.contains(key))
				continue;
			Stack<String> stack = new Stack<String>();
			List<String> list = new ArrayList<String>();
			stack.add(key);
			while (!stack.isEmpty()) {
				String popVal = stack.pop();
				if (!visited.contains(popVal)) {
					list.add(popVal);
					visited.add(popVal);
					List<String> newList = emailsMap.get(popVal);
					for (String str : newList) {
						stack.push(str);
					}
				}
			}
			Collections.sort(list);
			list.add(0, emailToNameMap.get(list.get(0)));
			output.add(list);
		}

		return output;
	}
}
