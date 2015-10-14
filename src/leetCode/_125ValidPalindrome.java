package leetCode;

/*
 * Link : https://leetcode.com/problems/pascals-triangle-ii/
 */

public class _125ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s=s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		StringBuilder sb=new StringBuilder(s);
		String reverseString=sb.reverse().toString();
		if(s.contentEquals(reverseString))
			return true;
		else
			return false;		
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}