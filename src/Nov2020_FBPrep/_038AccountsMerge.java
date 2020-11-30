package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class _038AccountsMerge {

	public static void main(String[] args) {
		System.out.println(accountsMerge(new ArrayList<List<String>>(
				Arrays.asList(new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")),
						new ArrayList<String>(Arrays.asList("John", "johnnybravo@mail.com")),
						new ArrayList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")),
						new ArrayList<String>(Arrays.asList("Mary", "mary@mail.com"))))));
		
		
		
		[["David","David0@m.co","David1@m.co"],
		 ["David","David3@m.co","David4@m.co"],
		 ["David","David4@m.co","David5@m.co"],
		 ["David","David2@m.co","David3@m.co"],
		 ["David","David1@m.co","David2@m.co"]]
		
		
	}

	static class Node {
		String accountHolderName;
		List<String> emails;

		public Node(String accountHolderName) {
			this.accountHolderName = accountHolderName;
			this.emails = new ArrayList<String>();
		}
	}

	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String, Node> map = new HashMap<String, Node>();
		List<List<String>> output = new ArrayList<List<String>>();
		HashSet<Node> set = new HashSet<Node>();
		for (List<String> list : accounts) {
			String name = list.get(0);
			Node node = null;
			for (int i = 1; i < list.size(); i++) {
				String email = list.get(i);
				if (map.containsKey(email)) {
					node = map.get(email);
					break;
				}
			}

			if (node == null) {
				node = new Node(name);
			}

			for (int i = 1; i < list.size(); i++) {
				String email = list.get(i);
				if (!map.containsKey(email)) {
					map.put(email, node);
					node.emails.add(email);
				}
			}
		}

		for (Map.Entry<String, Node> entry : map.entrySet()) {
			if (!set.contains(entry.getValue())) {
				Node val = entry.getValue();
				set.add(val);
				List<String> outValue = val.emails;
				Collections.sort(outValue);
				outValue.add(0, val.accountHolderName);
				output.add(outValue);
			}
		}

		return output;
	}
}
