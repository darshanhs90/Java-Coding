package Mar2021Leetcode;

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

		List<Integer> output = new ArrayList<Integer>();
		int wordLength = words[0].length();
		int totalLength = wordLength * words.length;

		for (int i = 0; i <= s.length() - totalLength; i++) {
			String str = s.substring(i, i + wordLength);

			if (map.containsKey(str)) {
				if (checkString(i, s, (HashMap<String, Integer>) map.clone(), wordLength, totalLength)) {
					output.add(i);
				}
			}
		}
		return output;
	}

	public static boolean checkString(int index, String s, HashMap<String, Integer> map, int wordLength,
			int totalLength) {
		int endIndex = index + totalLength;
		while (index < endIndex) {
			String str = s.substring(index, index + wordLength);
			if (!map.containsKey(str) || map.get(str) <= 0)
				return false;
			map.put(str, map.get(str) - 1);
			index += wordLength;
		}
		return true;
	}
}
