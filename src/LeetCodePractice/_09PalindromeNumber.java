package LeetCodePractice;

public class _09PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147447412));
	}
	public static boolean isPalindrome(int x) {
		if(x<0)return false;
		String str=x+"";
		return isPalindromeNum(str,0);
	}
	private static boolean isPalindromeNum(String str, int i) {
		if(str.length()==0||str.length()==1)
			return true;
		return str.charAt(i)==str.charAt(str.length()-1-i) && isPalindromeNum(str.substring(1, str.length()-1), i);
	}	
}
