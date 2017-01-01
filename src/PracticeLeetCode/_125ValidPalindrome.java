package PracticeLeetCode;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	public static boolean isPalindrome(String s) {
		s=s.replaceAll("[^A-Za-z0-9]", "").trim().toLowerCase();
		return new StringBuilder(s).reverse().toString().contentEquals(s);
	}
}
