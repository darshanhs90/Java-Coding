package LeetCodePerformancePractice;

public class _005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("Neoemalayalameo"));
	}
	public static String longestPalindrome(String s) {
		String longest="";
		for (int i = 0; i < s.length(); i++) {
			String str=helper(s,i,i);
			if(str.length()>longest.length())
				longest=str;
			str=helper(s,i,i+1);
			if(str.length()>longest.length())
				longest=str;
		}
		return longest;
	}
	private static String helper(String s, int start,int end) {
		while(start>=0 && end<s.length() && start<=end && s.charAt(start)==s.charAt(end))
		{
			start--;
			end++;
		}
		return s.substring(start+1,end);
	}
}
