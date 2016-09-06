package LeetCodePerformancePractice;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	private static int lengthOfLongestSubstring(String string) {
		if(string==null||string.length()==0)
			return 0;

		StringBuilder sb=new StringBuilder();
		int maxLength=Integer.MIN_VALUE;
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(sb.toString().contains(c+""))
			{
				sb=new StringBuilder(sb.substring(sb.indexOf(c+"")+1)+c);
			}
			else
				sb.append(c);
			maxLength=Math.max(sb.length(), maxLength);	
		}
		return maxLength;
	}

}
