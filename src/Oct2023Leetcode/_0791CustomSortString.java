package Oct2023Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _0791CustomSortString {
	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
		System.out.println(customSortString("cbafg", "abcd"));
	}

	public static String customSortString(String S, String T) {
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		HashSet<Character> orderSet = new HashSet<Character>();
		for (int i = 0; i < T.length(); i++) {
			tMap.compute(T.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			orderSet.add(ch);
			if (tMap.containsKey(ch)) {
				int count = tMap.get(ch);
				for (int j = 0; j < count; j++) {
					sb.append(ch);
				}
			}
		}
		for (int i = 0; i < T.length(); i++) {
			char ch = T.charAt(i);
			if (!orderSet.contains(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
