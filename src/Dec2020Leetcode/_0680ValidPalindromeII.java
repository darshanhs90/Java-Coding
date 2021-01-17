package Dec2020Leetcode;

public class _0680ValidPalindromeII {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abcd"));
	}

	public static boolean validPalindrome(String s) {
		if (s.length() < 3)
			return true;
		int left = 0, right = s.length() - 1;
		while (left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if (leftChar == rightChar) {
				left++;
				right--;
			} else {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
		}
		return true;
	}

	public static boolean isPalindrome(String s, int left, int right) {
		while (left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if (leftChar == rightChar) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

}
