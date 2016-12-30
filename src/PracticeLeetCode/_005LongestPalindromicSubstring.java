package PracticeLeetCode;

public class _005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("Neoemalayalameo"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("babad"));

	}
	public static String longestPalindrome(String s) {
		if(s==null||s.length()<2)
			return s;
		String output="";
		for (int i = 0; i < s.length(); i++) {
			String temp=helper(s,i,i);
			if(temp.length()>output.length())
				output=temp;
			temp=helper(s,i,i+1);
			if(temp.length()>output.length())
				output=temp;
		}
		return output;
	}
	private static String helper(String s, int start, int end) {
		if(start<0||end>=s.length()||start>end)
			return "";
		while(start>=0 && end<s.length() && start<=end && s.charAt(start)==s.charAt(end))
		{
			start--;
			end++;
		}
		return s.substring(start+1,end);
	}





}
