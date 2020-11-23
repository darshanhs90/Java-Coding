package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0811SubdomainVisitCount {
	public static void main(String[] args) {
		System.out.println(subdomainVisits(new String[] { "9001 discuss.leetcode.com" }));
		System.out.println(subdomainVisits(
				new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }));
	}

	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < cpdomains.length; i++) {
			String[] domainArray = cpdomains[i].split(" ");
			int count = Integer.parseInt(domainArray[0]);
			String domain = domainArray[1];
			while (domain != null && domain.length() > 0) {
				if (map.containsKey(domain)) {
					map.computeIfPresent(domain, (k, v) -> v + count);
				} else {
					map.put(domain, count);
				}

				domain = domain.indexOf('.') > -1 ? domain.substring(domain.indexOf('.') + 1) : null;
			}
		}
		List<String> output = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			output.add(entry.getValue() + " " + entry.getKey());
		}
		return output;
	}
}
