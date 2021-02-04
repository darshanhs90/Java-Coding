package Jan2021Leetcode;

public class _0009PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(-101));
		System.out.println(isPalindrome(49));
	}

	public static boolean isPalindrome(int num) {
		if (num < 0)
			return false;
		String str = String.valueOf(num);
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			char c1 = str.charAt(left);
			char c2 = str.charAt(right);
			if (c1 != c2)
				return false;
			left++;
			right--;
		}
		return true;
	}

}
