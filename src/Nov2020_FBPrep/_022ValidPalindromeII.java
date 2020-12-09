package Nov2020_FBPrep;

public class _022ValidPalindromeII {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abca"));
		System.out.println(validPalindrome("abdca"));
	}

	static class ValueNode {
		int left;
		int right;
		boolean isPalindrome;

		public ValueNode(int left, int right, boolean isPalindrome) {
			this.left = left;
			this.right = right;
			this.isPalindrome = isPalindrome;
		}
	}

	public static boolean validPalindrome(String s) {
		if (s == null || s.length() < 3)
			return true;

		ValueNode vn = isValidPalindrome(s, 0, s.length() - 1);
		if (vn.isPalindrome)
			return true;
		else {
			return isValidPalindrome(s, vn.left + 1, vn.right).isPalindrome
					|| isValidPalindrome(s, vn.left, vn.right - 1).isPalindrome;
		}
	}

	public static ValueNode isValidPalindrome(String s, int left, int right) {
		while (left < right) {
			char c1 = s.charAt(left);
			char c2 = s.charAt(right);
			if (c1 != c2) {
				return new ValueNode(left, right, false);
			}
			left++;
			right--;
		}
		return new ValueNode(left, right, true);
	}

}
