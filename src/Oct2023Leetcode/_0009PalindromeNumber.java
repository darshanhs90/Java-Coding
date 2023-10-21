package Oct2023Leetcode;

public class _0009PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
		System.out.println(isPalindrome(49));
	}

	public static boolean isPalindrome(int x) {
		String num = String.valueOf(x);
		return num.equals(new StringBuilder(num).reverse().toString());
	}

}
