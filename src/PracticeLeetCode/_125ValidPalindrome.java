package PracticeLeetCode;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	public static boolean isPalindrome(String s) {
		s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").trim();
		return s.contentEquals(new StringBuilder(s).reverse().toString());
	}
}
