package Feb2021Leetcode;

public class _0009PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
		System.out.println(isPalindrome(49));
	}

	public static boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
