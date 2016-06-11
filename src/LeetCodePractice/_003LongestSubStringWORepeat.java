package LeetCodePractice;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	public static int lengthOfLongestSubstring(String s) {
		StringBuilder sb=new StringBuilder("");
		int maxLen=Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if(sb.length()>0 && sb.toString().indexOf(s.charAt(i))!=-1){
				sb=new StringBuilder(sb.toString().substring(sb.toString().indexOf(s.charAt(i))+1));
				sb.append(s.charAt(i));
			}
			else{
				sb.append(s.charAt(i));
				maxLen=Math.max(sb.length(), maxLen);
			}
		}
		return sb.length()>maxLen?sb.length():maxLen;
	}
}
