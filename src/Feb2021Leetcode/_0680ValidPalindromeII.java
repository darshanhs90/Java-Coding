package Feb2021Leetcode;

public class _0680ValidPalindromeII {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abcd"));
		System.out.println(validPalindrome("abca"));
	}

	public static boolean validPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
			left++;
			right--;
		}
		return true;
	}

	public static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
