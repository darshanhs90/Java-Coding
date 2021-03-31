package Mar2021Leetcode;

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
		for (String word : cpdomains) {
			String strArr[] = word.split(" ");
			int count = Integer.parseInt(strArr[0]);
			String str[] = strArr[1].split("\\.");
			StringBuilder sb = new StringBuilder();
			for (int i = str.length - 1; i >= 0; i--) {
				if (sb.length() == 0) {
					sb.append(str[i]);
				} else {
					sb.insert(0, str[i] + ".");
				}
				map.compute(sb.toString(), (k, v) -> v == null ? count : v + count);
			}
		}
		List<String> out = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			out.add(entry.getValue() + " " + entry.getKey());
		}
		return out;
	}
}
