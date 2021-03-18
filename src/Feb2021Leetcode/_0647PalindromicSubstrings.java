package Feb2021Leetcode;

public class _0647PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

	static int count;

	public static int countSubstrings(String s) {
		count = 0;
		for (int i = 0; i < s.length(); i++) {
			checkPalindrome(i, i, s);

			if (i + 1 < s.length())
				checkPalindrome(i, i + 1, s);
		}
		return count;
	}

	public static void checkPalindrome(int left, int right, String s) {
		while (left <= right && left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
	}
}
