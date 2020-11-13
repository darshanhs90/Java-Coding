package Leetcode2020Nov;

public class _0520DetectCapital {

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("Flag"));
		System.out.println(detectCapitalUse("leetcode"));
		System.out.println(detectCapitalUse("FlaG"));
	}

	public static boolean detectCapitalUse(String word) {
		if (word == null || word.length() == 0)
			return true;
		int numberOfCaps = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.toLowerCase(c) != c) {
				numberOfCaps++;
			}
		}
		if (numberOfCaps == word.length() || numberOfCaps == 0
				|| numberOfCaps == 1 && Character.toLowerCase(word.charAt(0)) != word.charAt(0))
			return true;
		return false;
	}
}
