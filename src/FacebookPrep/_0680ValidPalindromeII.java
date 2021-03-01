package FacebookPrep;

public class _0680ValidPalindromeII {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abcd"));
		System.out.println(validPalindrome("abca"));
	}

	public static boolean validPalindrome(String s) {
		if (s == null || s.length() < 2)
			return true;
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(left + 1, right, s) || isPalindrome(left, right - 1, s);
			}
			left++;
			right--;
		}
		return true;
	}

	public static boolean isPalindrome(int left, int right, String s) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
