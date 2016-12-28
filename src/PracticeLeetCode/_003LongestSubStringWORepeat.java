package PracticeLeetCode;

public class _003LongestSubStringWORepeat {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {

		if(s==null||s.length()==0)
			return 0;
		StringBuilder sb=new StringBuilder(s.charAt(0)+"");
		int maxSize=sb.length();
		for (int i = 1; i < s.length(); i++) {
			char c=s.charAt(i);
			if(sb.toString().indexOf(c+"")>-1){
				sb=new StringBuilder(sb.substring(sb.indexOf(c+"")+1));
			}
			sb.append(c);
			maxSize=Integer.max(sb.length(), maxSize);
		}
		return maxSize;
	}



}
