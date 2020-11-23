package Nov2020Leetcode;

public class _0125ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int leftIndex = 0, rightIndex = s.length() - 1;
		while (leftIndex < rightIndex) {
			char leftChar = s.charAt(leftIndex);
			char rightChar = s.charAt(rightIndex);
			if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar) && leftChar != rightChar) {
				return false;
			} else if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
				leftIndex++;
				rightIndex--;
			} else if (Character.isLetterOrDigit(leftChar)) {
				rightIndex--;
			} else {
				leftIndex++;
			}
		}
		return true;
	}
}
