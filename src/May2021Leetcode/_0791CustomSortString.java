package May2021Leetcode;

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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i) + "", i);
		}

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < T.length(); i++) {
			list.add(T.charAt(i) + "");
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String c1, String c2) {
				int val1 = map.containsKey(c1) ? map.get(c1) : -1;
				int val2 = map.containsKey(c2) ? map.get(c2) : -1;
				return val1 - val2;
			}
		});

		return String.join("", list);
	}

}
