package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _0791CustomSortString {
	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
	}

	public static String customSortString(String S, String T) {

		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			sMap.put(S.charAt(i), i);
		}

		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		List<Character> lst = new ArrayList<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (sMap.containsKey(c)) {
				if (!tMap.containsKey(c)) {
					lst.add(c);
				}
				tMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
			} else {
				sb.append(c);
			}
		}

		Collections.sort(lst, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return sMap.get(o1) - sMap.get(o2);
			}
		});

		for (Character c : lst) {
			int count = tMap.get(c);
			for (int i = 0; i < count; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
