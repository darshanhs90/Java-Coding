package eBayPrep;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
		System.out.println(lengthOfLongestSubstring("aab"));
		
	}
	public static int lengthOfLongestSubstring(String s) {
		int maxLength=0;
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(sb.toString().contains(c+""))
			{
				sb.append(c);
				sb=new StringBuilder(sb.substring(sb.toString().indexOf(c)+1));
			}
			else{
				sb.append(c);
				maxLength=Math.max(sb.length(), maxLength);
			}
		}
		return maxLength;
	}
}
