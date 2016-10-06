package PracticeLeetCode;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	private static int lengthOfLongestSubstring(String string) {
		int maxLength=0;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c=string.charAt(i);
			if(sb.indexOf(c+"")>-1)
			{
				sb=new StringBuilder(sb.toString().substring(sb.indexOf(c+"")+1));
			}
			sb.append(c);
			maxLength=Math.max(maxLength, sb.length());
		}
		return maxLength;
	}

	

}
