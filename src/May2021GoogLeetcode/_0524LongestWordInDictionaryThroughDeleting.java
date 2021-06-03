package May2021GoogLeetcode;

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
		String minString = "";
		int minLength = Integer.MIN_VALUE;
		for (String str : dictionary) {
			boolean matches = match(s, str);
			if (matches) {
				if (str.length() > minLength) {
					minLength = str.length();
					minString = str;
				} else if (str.length() == minLength && str.compareTo(minString) < 0) {
					minString = str;
				}
			}
		}
		return minString;
	}

	public static boolean match(String s, String baseString) {
		int index1 = 0, index2 = 0;
		while (index1 < s.length() && index2 < baseString.length()) {
			if (s.charAt(index1) == baseString.charAt(index2)) {
				index2++;
			}
			index1++;
		}
		return index2 == baseString.length();
	}
}
