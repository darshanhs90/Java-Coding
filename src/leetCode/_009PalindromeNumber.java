package leetCode;

/*
 * Link : https://leetcode.com/problems/palindrome-number/
 */

public class _009PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if(x<0)
			return false;
		int div=1;
		while(x/div>=10)
		{
			div*=10;
		}
		while(x>1)
		{	
			int left=x/div;
			int right=x%10;
			if(left!=right)
				return false;
			x=(x%div)/10;
			div=div/100;
		}
		return true;
	}
	public static boolean isPalindromeExtraSpace(int x) {
		String str=String.valueOf(x);
		for (int i = 0; i <=str.length()/2; i++) {	
			if(str.charAt(i)!=str.charAt(str.length()-i-1))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindromeExtraSpace(12321));
		System.out.println(isPalindrome(313));

	}
}