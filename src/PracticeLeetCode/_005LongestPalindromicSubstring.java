package PracticeLeetCode;

public class _005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("Neoemalayalameo"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("babad"));

	}
	public static String longestPalindrome(String s) {
		if(s==null||s.length()<=1)
			return s;
		String longest="";
		String temp="";
		for (int i = 0; i < s.length(); i++) {
			temp=helper(i,i,s);
			if(temp.length()>longest.length())
				longest=temp;
			temp=helper(i,i+1,s);
			if(temp.length()>longest.length())
				longest=temp;
		}
		return longest;
	}
	private static String helper(int start, int end, String s) {
		if(s==null||s.length()==0||start>end)
			return "";
		while(start>=0 && end<s.length() && start<=end && s.charAt(start)==s.charAt(end))
		{
			start--;
			end++;
		}
		return s.substring(start+1,end);
	}





}
