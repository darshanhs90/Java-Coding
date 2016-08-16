package LeetCodePerformancePractice;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	public static int lengthOfLongestSubstring(String s) {
		int length=0;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(sb.toString().contains(c+""))
			{
				sb=new StringBuilder(sb.toString().substring(sb.toString().indexOf(c)+1));
				sb.append(c);
			}
			else
			{
				sb.append(c);
			}
			length=Math.max(sb.length(), length);
		}
		return length;
	}
}
