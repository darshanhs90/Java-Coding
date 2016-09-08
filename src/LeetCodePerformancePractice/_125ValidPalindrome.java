package LeetCodePerformancePractice;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
    public static boolean isPalindrome(String s) {
    	s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return new StringBuilder(s).reverse().toString().contentEquals(s);
    }
}
