package PracticeLeetCode;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
		System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
		System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
		System.out.println(lengthOfLongestSubstring(" ") == 1);
		System.out.println(lengthOfLongestSubstring("au") == 2);
		System.out.println(lengthOfLongestSubstring("abba") == 2);
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = sb.indexOf(c + "");
			if (index != -1) {
				sb = new StringBuilder(sb.substring(index + 1));
			}
			sb.append(c);
			maxLen = Math.max(maxLen, sb.length());
		}
		return maxLen;
	}

}
