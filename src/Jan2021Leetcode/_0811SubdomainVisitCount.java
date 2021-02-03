package Jan2021Leetcode;

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
			String domain = cpdomains[i];
			String[] domainSplit = domain.split(" ");
			int val = Integer.parseInt(domainSplit[0]);
			String[] domains = domainSplit[1].split("\\.");
			String str = "";
			for (int j = domains.length - 1; j >= 0; j--) {
				str = domains[j]+str;
				map.compute(str, (k, v) -> v == null ? val : val + v);
				str = "." + str;
			}
		}

		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			list.add(entry.getValue() + " " + entry.getKey());
		}
		return list;
	}
}
