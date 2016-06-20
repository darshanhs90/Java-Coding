package LeetCodePractice;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindromeRecursive("A man, a plan, a canal: Panama"));

	}
	public static boolean isPalindrome(String s) {
		s=s.replaceAll("[^a-zA-Z0-9]", "");
		return new StringBuilder(s.toLowerCase()).reverse().toString().contentEquals(s.toLowerCase());
	}
	public static boolean isPalindromeRecursive(String s) {
		s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		if(s.length()<=1)
			return true;
		return checkPalindrome(s,0,s.length()-1);
	}
	private static boolean checkPalindrome(String s, int i, int j) {
		if(i<=j)
			return s.charAt(i)==s.charAt(j) && checkPalindrome(s, i+1, j-1);
		else 
			return s.charAt(i)==s.charAt(j);
	}
}

