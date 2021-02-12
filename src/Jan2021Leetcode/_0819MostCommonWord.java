package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _0819MostCommonWord {
	public static void main(String[] args) {
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
		System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[] { "a" }));
		System.out.println(mostCommonWord("a?", new String[] {  }));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashSet<String> set = new HashSet<String>(new ArrayList<String>(Arrays.asList(banned)));
		paragraph = paragraph.replaceAll("!", " ");
		paragraph = paragraph.replaceAll("\\?", " ");
		paragraph = paragraph.replaceAll("'", " ");
		paragraph = paragraph.replaceAll(",", " ");
		paragraph = paragraph.replaceAll(";", " ");
		paragraph = paragraph.replaceAll("\\.", " ");
		String str = "";
		int maxCount = 0;
		String[] strArr = paragraph.toLowerCase().split(" ");
		for (int i = 0; i < strArr.length; i++) {
			String word = strArr[i];
			if (!set.contains(word) && word.length() > 0) {
				map.compute(word, (k, v) -> v == null ? 1 : v + 1);

				if (map.get(word) > maxCount) {
					str = word;
					maxCount = map.get(word);
				}
			}
		}
		return str;
	}
}
