package May2021Leetcode;

public class _0125ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		s = s.toLowerCase();
		while (left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
				if (leftChar != rightChar)
					return false;
				left++;
				right--;
			} else if (Character.isLetterOrDigit(leftChar)) {
				right--;
			} else if (Character.isLetterOrDigit(rightChar)) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}
}
