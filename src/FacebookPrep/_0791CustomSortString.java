package FacebookPrep;

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
		HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			charIndexMap.put(S.charAt(i), i);
		}

		List<Character> list = new ArrayList<Character>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (charIndexMap.containsKey(c))
				list.add(c);
			else {
				sb.append(c);
			}
		}
		Collections.sort(list, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return charIndexMap.get(o1) - charIndexMap.get(o2);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}

}
