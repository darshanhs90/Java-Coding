package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0030SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
		System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }));
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> output = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int length = 0;
		for (String word : words) {
			map.compute(word, (k, v) -> v == null ? 1 : v + 1);
			length += word.length();
		}
		int wordLength = words[0].length();
		for (int i = 0; i < s.length() - length + 1; i++) {
			HashMap<String, Integer> seen = new HashMap<String, Integer>();
			int j = i;
			while (j < (i + length)) {
				String str = s.substring(j, j + wordLength);
				if (map.containsKey(str)
						&& (!seen.containsKey(str) || seen.get(str).intValue() < map.get(str).intValue())) {
					seen.compute(str, (k, v) -> v == null ? 1 : v + 1);
					j += wordLength;
				} else {
					break;
				}
			}

			if (j == i + length) {
				output.add(i);
			}
		}
		return output;
	}
}
