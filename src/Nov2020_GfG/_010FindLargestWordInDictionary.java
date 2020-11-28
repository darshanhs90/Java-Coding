package Nov2020_GfG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _010FindLargestWordInDictionary {

	public static void main(String[] args) {
		System.out.println(
				findLongestWord("abpcplea", new ArrayList<String>(Arrays.asList("ale", "apple", "monkey", "plea"))));
		System.out.println(findLongestWord("abpcplea", new ArrayList<String>(Arrays.asList("a", "b", "c"))));
	}

	static String findLongestWord(String S, List<String> d) {
		String longestWord = "";
		for (String string : d) {
			char mainStringArr[] = S.toCharArray();
			char currStringArr[] = string.toCharArray();
			int mainStringIndex = 0;
			int currStringIndex = 0;

			while (mainStringIndex < mainStringArr.length && currStringIndex < currStringArr.length) {
				if (currStringArr[currStringIndex] == mainStringArr[mainStringIndex]) {
					currStringIndex += 1;
					mainStringIndex += 1;
				} else {
					mainStringIndex += 1;
				}
			}
			if (currStringIndex == currStringArr.length) {
				if (string.length() > longestWord.length())
					longestWord = string;
			}
		}
		return longestWord;
	}
}
