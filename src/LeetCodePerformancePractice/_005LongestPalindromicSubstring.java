package LeetCodePerformancePractice;

public class _005LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("Neoemalayalameo"));
	}

	private static String longestPalindrome(String string) {
		if(string==null||string.length()<=1)
			return string;
		String longestString="";
		for (int i = 0; i < string.length(); i++) {
			String str=helper(string,i,i);
			if(str.length()>longestString.length())
				longestString=str;
			str=helper(string,i,i+1);
			if(str.length()>longestString.length())
				longestString=str;
		}
		return longestString;
	}

	private static String helper(String string, int start,int end) {
		while(start>=0 && end<=string.length()-1 && string.charAt(start)==string.charAt(end))
		{
			start--;
			end++;
		}
		return string.substring(start+1,end);
	}




}
