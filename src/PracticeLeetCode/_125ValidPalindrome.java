package PracticeLeetCode;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	public static boolean isPalindrome(String s) {
		if(s==null||s.length()==0)
			return true;
		s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
		StringBuilder sb=new StringBuilder(s);
		if(s.contentEquals(sb.reverse().toString()))
			return true;
		return false;
	}
}
