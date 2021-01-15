package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1163LastSubstringInLexicographicalOrder {
	public static void main(String[] args) {
		System.out.println(lastSubstring("abab"));
		System.out.println(lastSubstring("leetcode"));
	}

	public static String lastSubstring(String s) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(i);
			for (int j = 0; j < sub.length(); j++) {
				String subString = sub.substring(0, j + 1);
				if (subString.length() > 0)
					list.add(subString);
			}
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int val = s1.compareTo(s2);
				if (val == 0)
					return s1.length() - s2.length();
				return val;
			}
		});
		return list.get(list.size() - 1);
	}

}
