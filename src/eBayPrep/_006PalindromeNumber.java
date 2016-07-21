package eBayPrep;

public class _006PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147447412));
	}
	public static boolean isPalindrome(int x) {
		x=Math.abs(x);
		return isPalindromeNum(x+"");
	}
	private static boolean isPalindromeNum(String string) {
		if(string.length()<=1)
			return true;
		return string.charAt(0)==string.charAt(string.length()-1) && isPalindromeNum(string.substring(1,string.length()-1));
	}	
}
