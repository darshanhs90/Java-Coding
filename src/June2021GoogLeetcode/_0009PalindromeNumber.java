package June2021GoogLeetcode;

public class _0009PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
		System.out.println(isPalindrome(49));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int reverseNumber = reverse(x);
		return x == reverseNumber;
	}

	public static int reverse(int x) {
		int val = 0;
		while (x > 0) {
			val = val * 10 + (x % 10);
			x = x / 10;
		}
		return val;
	}

}
