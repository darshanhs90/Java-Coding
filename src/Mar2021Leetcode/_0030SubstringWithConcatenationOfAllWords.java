package Mar2021Leetcode;

import java.util.List;

public class _0030SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
		System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }));
	}

	public static List<Integer> findSubstring(String s, String[] words) {

	}
}
