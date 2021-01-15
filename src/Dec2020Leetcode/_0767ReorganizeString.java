package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0767ReorganizeString {

	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaab"));
	}

	static class WordPair {
		char c;
		int count;

		public WordPair(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public static String reorganizeString(String S) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			map.compute(S.charAt(i), (k, v) -> v == null ? 1 : v + 1);
		}

		List<WordPair> list = new ArrayList<WordPair>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			list.add(new WordPair(entry.getKey(), entry.getValue()));
		}
		Collections.sort(list, new Comparator<WordPair>() {

			@Override
			public int compare(WordPair o1, WordPair o2) {
				// TODO Auto-generated method stub
				return o1.count - o2.count;
			}
		});

		char[] ans = new char[S.length()];
		int index = 1;
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).count;
			char c = list.get(i).c;

			if (count > (S.length() + 1) / 2)
				return "";

			for (int j = 0; j < count; j++) {
				if (index >= S.length())
					index = 0;
				ans[index] = c;
				index += 2;
			}
		}
		return new String(ans);
	}
}
