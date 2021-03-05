package FacebookPortalPrep;

public class _0017Recursion_EncryptedWords {

	public static void main(String[] args) {
		System.out.println(findEncryptedWord("abc"));
		System.out.println(findEncryptedWord("abcd"));
		System.out.println(findEncryptedWord("abcxcba"));
		System.out.println(findEncryptedWord("facebook"));
	}

	public static String findEncryptedWord(String s) {
		// Write your code here
		if (s.length() <= 1)
			return s;

		int midIndex = s.length() % 2 == 0 ? s.length() / 2 - 1 : s.length() / 2;

		return s.charAt(midIndex) + findEncryptedWord(s.substring(0, midIndex))
				+ findEncryptedWord(s.substring(midIndex + 1));

	}
}
