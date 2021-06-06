package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0524LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {
		System.out.println(
				findLongestWord("abpcplea", new ArrayList<String>(Arrays.asList("ale", "apple", "monkey", "plea"))));
		System.out.println(findLongestWord("abpcplea", new ArrayList<String>(Arrays.asList("a", "b", "c"))));
	}

	public static String findLongestWord(String s, List<String> dictionary) {
		String longestWord = "";
		for (String str : dictionary) {
			if (isMatch(s, str)) {
				if (str.length() > longestWord.length()) {
					longestWord = str;
				} else if (str.length() == longestWord.length() && str.compareTo(longestWord) < 0) {
					longestWord = str;
				}
			}
		}
		return longestWord;
	}

	public static boolean isMatch(String s, String str) {
		int sIndex = 0, strIndex = 0;
		while (strIndex < str.length() && sIndex < s.length()) {
			if (s.charAt(sIndex) == str.charAt(strIndex)) {
				sIndex++;
				strIndex++;
			} else {
				sIndex++;
			}
		}
		return strIndex == str.length();
	}
}
