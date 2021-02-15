package Jan2021Leetcode;

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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			map.compute(words[i], (k, v) -> v == null ? 1 : v + 1);
		}

		int length = words[0].length();
		int totalLength = words.length * length;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= s.length() - totalLength; i++) {
			if (matches(i, s, length, totalLength, map))
				list.add(i);
		}
		return list;
	}

	public static boolean matches(int index, String s, int length, int maxLength, HashMap<String, Integer> map) {
		HashMap<String, Integer> mapClone = (HashMap<String, Integer>) map.clone();

		for (int i = index; i < s.length() && i < index + maxLength; i += length) {
			String subString = s.substring(i, i + length);
			if (mapClone.containsKey(subString) && mapClone.get(subString) > 0) {
				mapClone.put(subString, mapClone.get(subString) - 1);
			} else
				return false;

		}

		return true;
	}
}
