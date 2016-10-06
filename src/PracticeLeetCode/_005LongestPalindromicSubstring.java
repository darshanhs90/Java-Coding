package PracticeLeetCode;

public class _005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("Neoemalayalameo"));
	}
	public static String longestPalindrome(String s) {
		if(s.length()<=1)
			return s;
		int maxLength=0;
		String maxLengthString="";
		for (int i = 0; i < s.length(); i++) {
			String str=helper(s,i,i);
			if(str.length()>maxLength)
				maxLengthString=str;
			maxLength=Math.max(maxLength, str.length());
			str=helper(s,i,i+1);
			if(str.length()>maxLength)
				maxLengthString=str;
			maxLength=Math.max(maxLength, str.length());
		}
		return maxLengthString;
	}
	private static String helper(String s, int start, int end) {
		while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
		{
			start--;
			end++;
		}
		return s.substring(start+1,end);
	}





}
