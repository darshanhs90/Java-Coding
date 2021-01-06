package Dec2020Leetcode;

public class _0520DetectCapital {

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("Flag"));
		System.out.println(detectCapitalUse("leetcode"));
		System.out.println(detectCapitalUse("FlaG"));
	}

	public static boolean detectCapitalUse(String word) {
		if (word == null || word.length() < 2)
			return true;

		// lowercase
		if (word.equals(word.toLowerCase()))
			return true;
		if (word.equals(word.toUpperCase()))
			return true;

		boolean hasFirstCaps = word.charAt(0) == Character.toUpperCase(word.charAt(0));
		return hasFirstCaps && word.substring(1).equals(word.substring(1).toLowerCase());
	}
}
