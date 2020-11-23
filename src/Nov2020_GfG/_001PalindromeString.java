package Nov2020_GfG;

public class _001PalindromeString {

	public static void main(String[] args) {
		System.out.println(isPlaindrome("abba"));
		System.out.println(isPlaindrome("abc"));

	}

	static int isPlaindrome(String S) {
		int left = 0, right = S.length() - 1;
		while (left < right) {
			if (S.charAt(left) != S.charAt(right))
				return 0;
			left++;
			right--;
		}
		return 1;
	}
}
