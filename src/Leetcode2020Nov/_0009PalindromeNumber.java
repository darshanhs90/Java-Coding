package Leetcode2020Nov;

public class _0009PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		} else if (x < 10) {
			return true;
		}
		StringBuilder sb = new StringBuilder(x + "");
		return sb.toString().contentEquals(sb.reverse().toString());
	}
}
