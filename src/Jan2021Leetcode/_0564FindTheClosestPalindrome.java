package Jan2021Leetcode;

public class _0564FindTheClosestPalindrome {
	public static void main(String[] args) {
		System.out.println(nearestPalindromic("123"));
	}

	public static String nearestPalindromic(String n) {
		int sum = 1;
		while (true) {
			int val = Integer.parseInt(n);
			int newVal = val - sum;
			if (newVal >= 0 && isPalindrome(String.valueOf(newVal)))
				return String.valueOf(newVal);
			newVal = val + sum;
			if (isPalindrome(String.valueOf(newVal)))
				return String.valueOf(newVal);
			sum++;
		}
	}

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
