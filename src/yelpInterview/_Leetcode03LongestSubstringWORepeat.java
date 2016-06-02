package yelpInterview;

public class _Leetcode03LongestSubstringWORepeat {

	public static void main(String a[]){
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("dvdf"));
		System.out.println(lengthOfLongestSubstring("bpfbhmipx"));


	}

	public static int lengthOfLongestSubstring(String s) {
		String str="";
		int maxLength=0;
		for (int i = 0; i < s.length(); i++) {
			if(!str.contains(s.charAt(i)+""))
			{
				str+=s.charAt(i);
			}
			else
			{
				maxLength=Math.max(maxLength, str.length());
				str=str.substring(str.indexOf(s.charAt(i))+1)+s.charAt(i);
			}
		}
		return maxLength>str.length()?maxLength:str.length();
	}
}

