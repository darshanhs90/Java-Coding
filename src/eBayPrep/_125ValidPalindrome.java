package eBayPrep;

public class _125ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	private static boolean isPalindrome(String str) {
		str=str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		StringBuilder sb=new StringBuilder(str);
		return sb.reverse().toString().contentEquals(str);
	}

}

